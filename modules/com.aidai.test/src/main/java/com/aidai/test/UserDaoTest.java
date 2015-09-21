package com.aidai.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.bootDelegationPackages;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.vmOption;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.Bundle;

@RunWith(JUnit4TestRunner.class)
public class UserDaoTest extends AbstractAidaiIntegrationTest {
	private static String Local_Repo = "f:/m2";
	private static String MAVEN_CONFIG_FILE = "F:/java/apache-maven-3.0.4/conf/settings.xml";
	private static String Project_Version = "1.0.0";

	@Test
	public void testBundlesStart() throws Exception {
		Bundle model = getInstalledBundle("com.aidai.model");
		assertNotNull(model);
		failInBundleNotActiveInFiveSeconds(model);
		assertEquals(Bundle.ACTIVE, model.getState());
		Bundle modelImpl = getInstalledBundle("com.aidai.model.impl");
		assertNotNull(modelImpl);
		failInBundleNotActiveInFiveSeconds(modelImpl);
		Bundle utils = getInstalledBundle("com.aidai.utils");
		assertNotNull(utils);
		failInBundleNotActiveInFiveSeconds(utils);
		Bundle datasource = getInstalledBundle("com.aidai.mysql.datasource");
		assertNotNull(datasource);
		failInBundleNotActiveInFiveSeconds(datasource);
		Bundle dao = getInstalledBundle("com.aidai.dao");
		assertNotNull(dao);
		failInBundleNotActiveInFiveSeconds(dao);
		Bundle daoImpl = getInstalledBundle("com.aidai.dao.impl");
		assertNotNull(daoImpl);
		
		Bundle service = getInstalledBundle("com.aidai.service");
		assertNotNull(service);
		failInBundleNotActiveInFiveSeconds(service);
		Bundle serviceImpl = getInstalledBundle("com.aidai.service.impl");
		assertNotNull(serviceImpl);
		failInBundleNotActiveInFiveSeconds(serviceImpl);
		Bundle api = getInstalledBundle("com.aidai.facade.service.api");
		assertNotNull(api);
		failInBundleNotActiveInFiveSeconds(api);
		Bundle impl = getInstalledBundle("com.aidai.facade.service.impl");
		assertNotNull(impl);
		failInBundleNotActiveInFiveSeconds(impl);
//		Bundle controller = getInstalledBundle("com.aidai.controller");
//		assertNotNull(controller);
//		failInBundleNotActiveInFiveSeconds(controller);
		Bundle web = getInstalledBundle("com.aidai.web");
		assertNotNull(web);
		failInBundleNotActiveInFiveSeconds(web);
	}
	private void failInBundleNotActiveInFiveSeconds(Bundle bapi) {
		for (int i = 0; i < 5 && Bundle.ACTIVE != bapi.getState(); i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		assertEquals("The bundle " + bapi.getSymbolicName() + " " + bapi.getVersion() + " is not active", Bundle.ACTIVE,
				bapi.getState());
	}
	@org.ops4j.pax.exam.junit.Configuration
	public static Option[] configuration() {
		Option[] options = 
				options(bootDelegationPackages("javax.transaction", "javax.transaction.*"), 
				vmOption("-Dorg.osgi.framework.system.packages.extra=javax.accessibility,javax.activation,javax.activity,javax.annotation,javax.annotation.processing,javax.crypto,javax.crypto.interfaces,javax.crypto.spec,javax.imageio,javax.imageio.event,javax.imageio.metadata,javax.imageio.plugins.bmp,javax.imageio.plugins.jpeg,javax.imageio.spi,javax.imageio.stream,javax.jws,javax.jws.soap,javax.lang.model,javax.lang.model.element,javax.lang.model.type,javax.lang.model.util,javax.management,javax.management.loading,javax.management.modelmbean,javax.management.monitor,javax.management.openmbean,javax.management.relation,javax.management.remote,javax.management.remote.rmi,javax.management.timer,javax.naming,javax.naming.directory,javax.naming.event,javax.naming.ldap,javax.naming.spi,javax.net,javax.net.ssl,javax.print,javax.print.attribute,javax.print.attribute.standard,javax.print.event,javax.rmi,javax.rmi.CORBA,javax.rmi.ssl,javax.script,javax.security.auth,javax.security.auth.callback,javax.security.auth.kerberos,javax.security.auth.login,javax.security.auth.spi,javax.security.auth.x500,javax.security.cert,javax.security.sasl,javax.sound.midi,javax.sound.midi.spi,javax.sound.sampled,javax.sound.sampled.spi,javax.sql,javax.sql.rowset,javax.sql.rowset.serial,javax.sql.rowset.spi,javax.swing,javax.swing.border,javax.swing.colorchooser,javax.swing.event,javax.swing.filechooser,javax.swing.plaf,javax.swing.plaf.basic,javax.swing.plaf.metal,javax.swing.plaf.multi,javax.swing.plaf.synth,javax.swing.table,javax.swing.text,javax.swing.text.html,javax.swing.text.html.parser,javax.swing.text.rtf,javax.swing.tree,javax.swing.undo,javax.tools,javax.xml,javax.xml.bind,javax.xml.bind.annotation,javax.xml.bind.annotation.adapters,javax.xml.bind.attachment,javax.xml.bind.helpers,javax.xml.bind.util,javax.xml.crypto,javax.xml.crypto.dom,javax.xml.crypto.dsig,javax.xml.crypto.dsig.dom,javax.xml.crypto.dsig.keyinfo,javax.xml.crypto.dsig.spec,javax.xml.datatype,javax.xml.namespace,javax.xml.parsers,javax.xml.soap,javax.xml.stream,javax.xml.stream.events,javax.xml.stream.util,javax.xml.transform,javax.xml.transform.dom,javax.xml.transform.sax,javax.xml.transform.stax,javax.xml.transform.stream,javax.xml.validation,javax.xml.ws,javax.xml.ws.handler,javax.xml.ws.handler.soap,javax.xml.ws.http,javax.xml.ws.soap,javax.xml.ws.spi,javax.xml.xpath,org.ietf.jgss,org.omg.CORBA,org.omg.CORBA.DynAnyPackage,org.omg.CORBA.ORBPackage,org.omg.CORBA.TypeCodePackage,org.omg.CORBA.portable,org.omg.CORBA_2_3,org.omg.CORBA_2_3.portable,org.omg.CosNaming,org.omg.CosNaming.NamingContextExtPackage,org.omg.CosNaming.NamingContextPackage,org.omg.Dynamic,org.omg.DynamicAny,org.omg.DynamicAny.DynAnyFactoryPackage,org.omg.DynamicAny.DynAnyPackage,org.omg.IOP,org.omg.IOP.CodecFactoryPackage,org.omg.IOP.CodecPackage,org.omg.Messaging,org.omg.PortableInterceptor,org.omg.PortableInterceptor.ORBInitInfoPackage,org.omg.PortableServer,org.omg.PortableServer.CurrentPackage,org.omg.PortableServer.POAManagerPackage,org.omg.PortableServer.POAPackage,org.omg.PortableServer.ServantLocatorPackage,org.omg.PortableServer.portable,org.omg.SendingContext,org.omg.stub.java.rmi,org.w3c.dom,org.w3c.dom.bootstrap,org.w3c.dom.css,org.w3c.dom.events,org.w3c.dom.html,org.w3c.dom.ls,org.w3c.dom.ranges,org.w3c.dom.stylesheets,org.w3c.dom.traversal,org.w3c.dom.views,org.xml.sax,org.xml.sax.ext,org.xml.sax.helpers,javax.transaction;partial=true;mandatory:=partial,javax.transaction.xa;partial=true;mandatory:=partial"),
				// config the maven repo
				vmOption("-Dorg.ops4j.pax.url.mvn.settings=" + MAVEN_CONFIG_FILE),
				vmOption("-Dorg.ops4j.pax.url.mvn.defaultRepositories=" + Local_Repo),
				vmOption("-Dorg.ops4j.pax.url.mvn.localRepository=" + Local_Repo),
				vmOption("-Dorg.ops4j.pax.url.mvn.defaultLocalRepoAsRemote=" + true),
				// Log
				mavenBundle("org.ops4j.pax.logging", "pax-logging-api", "1.5.0"),
				mavenBundle("org.ops4j.pax.logging", "pax-logging-service", "1.5.0"),
				// Felix mvn url handler - do we need this?
				mavenBundle("org.ops4j.pax.url", "pax-url-mvn", "1.3.5"),
				// Bundles
				mavenBundle("org.eclipse.equinox", "cm", "3.2.0-v20070116"),
				mavenBundle("org.eclipse.osgi", "services", "3.1.200-v20070605"),
				mavenBundle("org.apache.aries.blueprint", "org.apache.aries.blueprint", "1.0.0"),
				mavenBundle("org.apache.aries.proxy", "org.apache.aries.proxy", "1.0.0"),
				mavenBundle("org.apache.aries", "org.apache.aries.util", "1.0.0"),
				mavenBundle("org.ow2.asm", "asm-all", "4.0"),
				
				mavenBundle("commons-lang","commons-lang","2.5"),
				//mysql connector
//				mavenBundle("mysql","mysql-connector-java","5.1.18"),
//				mavenBundle("com.mchange.c3p0", "com.springsource.com.mchange.v2.c3p0","0.9.1"),
//				mavenBundle("com.mchange","c3p0","0.9.5"),
				
				//derby driver
				mavenBundle("org.apache.derby", "derby","10.5.3.0_1"),
				
//				mavenBundle("commons-pool","commons-pool","1.5.4"),
//				mavenBundle("org.apache.commons","com.springsource.org.apache.commons.dbcp","1.2.2.osgi"),
				
//				mavenBundle("javax.transaction","com.springsource.javax.transaction","1.1.0"),
//				mavenBundle("commons-dbcp","commons-dbcp","1.4"),
//				mavenBundle("com.mchange","c3p0","0.9.5"),
				
				systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("DEBUG"),
				/* For debugging, uncomment the next two lines */
//				 vmOption ("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=7777"),
//				 waitForFrameworkStartup(),
				 
				/*
				 * For debugging, add these imports: import static
				 * org.ops4j.pax.exam.CoreOptions.waitForFrameworkStartup; import static
				 * org.ops4j.pax.exam.container.def.PaxRunnerOptions.vmOption;
				 */
				// project dependencies
				mavenBundle("com.aidai", "com.aidai.model", Project_Version),
				mavenBundle("com.aidai", "com.aidai.model.impl", Project_Version),
				mavenBundle("com.aidai", "com.aidai.mysql.datasource", Project_Version),
				mavenBundle("com.aidai", "com.aidai.utils", Project_Version),
				mavenBundle("com.aidai", "com.aidai.dao", Project_Version),
				mavenBundle("com.aidai", "com.aidai.dao.impl", Project_Version),
				mavenBundle("com.aidai", "com.aidai.service", Project_Version),
				mavenBundle("com.aidai", "com.aidai.service.impl", Project_Version),
				mavenBundle("com.aidai", "com.aidai.facade.service.api", Project_Version),
				mavenBundle("com.aidai", "com.aidai.facade.service.impl", Project_Version),
//				mavenBundle("com.aidai", "com.aidai.controller", Project_Version),
				mavenBundle("com.aidai", "com.aidai.web", Project_Version), 
				equinox().version("3.5.0"));
		options = updateOptions(options);
		return options;
	}
}
