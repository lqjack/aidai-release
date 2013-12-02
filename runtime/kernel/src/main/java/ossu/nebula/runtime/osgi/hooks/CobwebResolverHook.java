/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ossu.nebula.runtime.osgi.hooks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;

/**
 *
 * @author hbzy76
 */
public class CobwebResolverHook implements ResolverHook {

    private Map<String, String> toFilterBundles = new ConcurrentHashMap<String, String>();
    private BundleContext bundleContext;

    public CobwebResolverHook(BundleContext bc) {
        toFilterBundles.put("ch.qos.logback.classic", "org.ops4j.pax.logging.pax-logging-api");
        toFilterBundles.put("org.eclipse.virgo.util.io", "org.ops4j.pax.logging.pax-logging-api");
        bundleContext = bc;
    }

    @Override
    public void filterResolvable(Collection<BundleRevision> candidates) {
        // do nothing
        Bundle logbackClassicBundle = null, logbackCoreBundle = null;
        for (Bundle b : bundleContext.getBundles()) {
            if (b.getSymbolicName().equals("ch.qos.logback.classic")) {
                logbackClassicBundle = b;
            }
            if (b.getSymbolicName().equals("ch.qos.logback.core")) {
                logbackCoreBundle = b;
            }
        }

        candidates = new ShrinkableCollection<BundleRevision>(candidates);
        
        List<BundleRevision> tobeRemoved = new ArrayList<BundleRevision>();

        for (BundleRevision candidate : candidates) {
            if (candidate.getSymbolicName().equals("org.eclipse.virgo.medic.logbackclassicfragment")) {
                if (logbackClassicBundle != null && !(logbackClassicBundle.getState() == Bundle.RESOLVED || logbackClassicBundle.getState() == Bundle.STARTING || logbackClassicBundle.getState() == Bundle.ACTIVE)) {
                   tobeRemoved.add(candidate);
                }
            }

            if (candidate.getSymbolicName().equals("org.eclipse.virgo.medic.logbackcorefragment")) {
                if (logbackCoreBundle != null && !(logbackCoreBundle.getState() == Bundle.RESOLVED || logbackCoreBundle.getState() == Bundle.STARTING || logbackCoreBundle.getState() == Bundle.ACTIVE)) {
                    tobeRemoved.add(candidate);
                }
            }
        }
        candidates.removeAll(tobeRemoved);
    }

    @Override
    public void filterSingletonCollisions(BundleCapability singleton, Collection<BundleCapability> candidates) {
        // do nothing
    }

    @Override
    public void filterMatches(BundleRequirement requirement, Collection<BundleCapability> candidates) {
        filterCapabilityBundles(requirement, candidates, toFilterBundles);
    }

    private void filterCapabilityBundles(BundleRequirement requirement, Collection<BundleCapability> candidates, Map<String, String> toFilterBundles) {
        Iterator<Entry<String, String>> iter = toFilterBundles.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> item = iter.next();
            if (requirement.getRevision().getSymbolicName().equals(item.getKey())) {
                //System.out.println("Requirement bundle: " + requirement.getRevision().getSymbolicName());
                //System.out.println("Requirement bundle: " + requirement.getRevision().getRequirements("osgi.wiring.package"));                        
                for (BundleCapability bc : candidates) {
                    //System.out.println("Capability bundle: " + bc.getRevision().getSymbolicName());
                    //System.out.println("Capability bundle: "+ bc.getRevision().getCapabilities("osgi.wiring.package"));
                    if (bc.getRevision().getSymbolicName().equals(item.getValue())) {
                        candidates.remove(bc);
                    }
                }
            }
        }
    }

    @Override
    public void end() {
        // do nothing
    }

}
