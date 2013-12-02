package ossu.nebula.runtime.hooks;

import java.util.ArrayList;
import java.util.Collection;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import ossu.nebula.runtime.osgi.hooks.CobwebResolverHookFactory;

/**
 *
 * @author chrisrc
 */
public class HooksActivator implements BundleActivator {

    Collection<ServiceRegistration<?>> registrations = new ArrayList<ServiceRegistration<?>>();

    private BundleContext bundleContext;

    @Override
    public void start(BundleContext bc) throws Exception {
        this.bundleContext = bc;
        this.registrations.add(this.bundleContext.registerService(ResolverHookFactory.class, new CobwebResolverHookFactory(bc), null));
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        for (ServiceRegistration<?> registration : registrations) {
            registration.unregister();
        }
    }

}
