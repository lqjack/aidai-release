/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ossu.nebula.runtime.osgi.hooks;

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import org.osgi.framework.wiring.BundleRevision;

/**
 *
 * @author hbzy76
 */
public class CobwebResolverHookFactory implements ResolverHookFactory {

    private BundleContext bundleContext;

    public CobwebResolverHookFactory(BundleContext bc) {
        bundleContext = bc;
    }

    @Override
    public ResolverHook begin(Collection<BundleRevision> clctn) {
        return new CobwebResolverHook(bundleContext);
    }

}
