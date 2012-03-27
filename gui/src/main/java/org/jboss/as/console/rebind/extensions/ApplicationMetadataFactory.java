/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.console.rebind.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.widgets.forms.AddressBinding;
import org.jboss.as.console.client.widgets.forms.BeanMetaData;
import org.jboss.as.console.client.widgets.forms.EntityFactory;
import org.jboss.as.console.client.widgets.forms.FormMetaData;
import org.jboss.as.console.client.widgets.forms.Getter;
import org.jboss.as.console.client.widgets.forms.Mutator;
import org.jboss.as.console.client.widgets.forms.PropertyBinding;
import org.jboss.as.console.client.widgets.forms.Setter;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 16, 2012
 */
public class ApplicationMetadataFactory {

//    private Map<Class<?>, List<PropertyBinding>> registry = new HashMap<Class<?>, List<PropertyBinding>>();
//    private Map<Class<?>, AddressBinding> addressing = new HashMap<Class<?>, AddressBinding>();
//    private Map<Class<?>, Mutator> mutators = new HashMap<Class<?>, Mutator>();
//    private Map<Class<?>, EntityFactory> factories = new HashMap<Class<?>, EntityFactory>();
//    private org.picketlink.as.console.client.BeanFactory beanFactory = com.google.gwt.core.client.GWT
//            .create(org.picketlink.as.console.client.BeanFactory.class);
//
//    public ApplicationMetadataFactory() {
//        super();
//        Federation_0();
//        ProfileRecord_1();
//        Queue_2();
//        FileHandler_3();
//        Host_4();
//        Server_5();
//        Logger_6();
//        RootLogger_7();
//        PropertyRecord_8();
//        RemoteService_9();
//        SubsystemRecord_10();
//        CommonSettings_11();
//        JSPContainerConfiguration_12();
//        Topic_13();
//        JPADeployment_14();
//        DeploymentRecord_15();
//        WebServiceEndpoint_16();
//        Module_17();
//        Jvm_18();
//        WorkmanagerPool_19();
//        CustomHandler_20();
//        SocketBinding_21();
//        ServerGroupRecord_22();
//        ServerInstance_23();
//        PoolConfig_24();
//        DataSource_25();
//        CacheContainer_26();
//        RuntimeMetric_27();
//        JMXSubsystem_28();
//        EESubsystem_29();
//        XADataSource_30();
//        ResourceAdapter_31();
//        ConnectionDefinition_32();
//        AdminObject_33();
//        ConnectionFactory_34();
//        EJB3Subsystem_35();
//        StrictMaxBeanPool_36();
//        AsyncService_37();
//        TimerService_38();
//        EJB3ThreadPool_39();
//        AsyncHandler_40();
//        ConsoleHandler_41();
//        PeriodicRotatingFileHandler_42();
//        SizeRotatingFileHandler_43();
//        DeploymentScanner_44();
//        SocketGroup_45();
//        DeploymentReference_46();
//        MessagingProvider_47();
//        SecurityPattern_48();
//        AddressingPattern_49();
//        HttpConnector_50();
//        VirtualServer_51();
//        Interface_52();
//        JDBCDriver_53();
//        StandaloneServer_54();
//        WebServiceProvider_55();
//        ConfigAdminData_56();
//        OSGiSubsystem_57();
//        OSGiCapability_58();
//        OSGiFramework_59();
//        OSGiBundle_60();
//        HeapMetric_61();
//        ThreadMetric_62();
//        OSMetric_63();
//        DefaultCacheContainer_64();
//        LocalCache_65();
//        InvalidationCache_66();
//        ReplicatedCache_67();
//        DistributedCache_68();
//        ThreadFactory_69();
//        BoundedQueueThreadPool_70();
//        BlockingBoundedQueueThreadPool_71();
//        UnboundedQueueThreadPool_72();
//        QueuelessThreadPool_73();
//        BlockingQueuelessThreadPool_74();
//        ScheduledThreadPool_75();
//        TransactionManager_76();
//        SecuritySubsystem_77();
//        SecurityDomain_78();
//        AuthenticationLoginModule_79();
//        AuthorizationPolicyProvider_80();
//        MappingModule_81();
//        GenericSecurityDomainData_82();
//        JpaSubsystem_83();
//        MailSession_84();
//        JcaArchiveValidation_85();
//        JcaBootstrapContext_86();
//        JcaBeanValidation_87();
//        JcaWorkmanager_88();
//        JcaConnectionManager_89();
//        JacOrbSubsystem_90();
//    }
//
//    public List<PropertyBinding> getBindingsForType(Class<?> type) {
//        return registry.get(type);
//    }
//
//    public BeanMetaData getBeanMetaData(Class<?> type) {
//        return new BeanMetaData(type, addressing.get(type), registry.get(type));
//    }
//
//    public FormMetaData getFormMetaData(Class<?> type) {
//        return new FormMetaData(type, registry.get(type));
//    }
//
//    public Mutator getMutator(Class<?> type) {
//        return mutators.get(type);
//    }
//
//    public <T> EntityFactory<T> getFactory(Class<T> type) {
//        return factories.get(type);
//    }
//
//    public void Federation_0() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.picketlink.as.console.client.shared.subsys.model.Federation.class, new ArrayList<PropertyBinding>());
//        Mutator mut_0 = new Mutator<org.picketlink.as.console.client.shared.subsys.model.Federation>();
//        mutators.put(org.picketlink.as.console.client.shared.subsys.model.Federation.class, mut_0);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.picketlink.as.console.client.shared.subsys.model.Federation.class).add(
//                new PropertyBinding("alias", "alias", "java.lang.String", listType, this, true, false, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_0.register("alias", new Setter<org.picketlink.as.console.client.shared.subsys.model.Federation>() {
//            public void invoke(org.picketlink.as.console.client.shared.subsys.model.Federation entity, Object value) {
//                entity.setAlias((java.lang.String) value);
//            }
//        });
//
//        mut_0.register("alias", new Getter<org.picketlink.as.console.client.shared.subsys.model.Federation>() {
//            public Object invoke(org.picketlink.as.console.client.shared.subsys.model.Federation entity) {
//                return entity.getAlias();
//            }
//        });
//
//        AddressBinding addr_0 = new AddressBinding();
//        addressing.put(org.picketlink.as.console.client.shared.subsys.model.Federation.class, addr_0);
//        addr_0.add("subsystem", "picketlink");
//        addr_0.add("federation", "{0}");
//        factories.put(org.picketlink.as.console.client.shared.subsys.model.Federation.class,
//                new EntityFactory<org.picketlink.as.console.client.shared.subsys.model.Federation>() {
//                    public org.picketlink.as.console.client.shared.subsys.model.Federation create() {
//                        return beanFactory.federation().as();
//                    }
//                });
//
//        // ---- End org.picketlink.as.console.client.shared.subsys.model.Federation ----
//    }
//
//    public void ProfileRecord_1() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.domain.model.ProfileRecord.class, new ArrayList<PropertyBinding>());
//        Mutator mut_1 = new Mutator<org.jboss.as.console.client.domain.model.ProfileRecord>();
//        mutators.put(org.jboss.as.console.client.domain.model.ProfileRecord.class, mut_1);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ProfileRecord.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_1.register("name", new Setter<org.jboss.as.console.client.domain.model.ProfileRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ProfileRecord entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_1.register("name", new Getter<org.jboss.as.console.client.domain.model.ProfileRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ProfileRecord entity) {
//                return entity.getName();
//            }
//        });
//
//        AddressBinding addr_1 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.domain.model.ProfileRecord.class, addr_1);
//        factories.put(org.jboss.as.console.client.domain.model.ProfileRecord.class,
//                new EntityFactory<org.jboss.as.console.client.domain.model.ProfileRecord>() {
//                    public org.jboss.as.console.client.domain.model.ProfileRecord create() {
//                        return beanFactory.profile().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.domain.model.ProfileRecord ----
//    }
//
//    public void Queue_2() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class, new ArrayList<PropertyBinding>());
//        Mutator mut_2 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class, mut_2);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class).add(
//                new PropertyBinding("selector", "selector", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_2.register("selector", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity, Object value) {
//                entity.setSelector((java.lang.String) value);
//            }
//        });
//
//        mut_2.register("selector", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity) {
//                return entity.getSelector();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class).add(
//                new PropertyBinding("durable", "durable", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_2.register("durable", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity, Object value) {
//                entity.setDurable((java.lang.Boolean) value);
//            }
//        });
//
//        mut_2.register("durable", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity) {
//                return entity.isDurable();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_2.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_2.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Queue entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        AddressBinding addr_2 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class, addr_2);
//        addr_2.add("subsystem", "messaging");
//        addr_2.add("hornetq-server", "{0}");
//        addr_2.add("jms-queue", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.Queue.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.Queue>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.Queue create() {
//                        return beanFactory.queue().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.Queue ----
//    }
//
//    public void FileHandler_3() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_3 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class, mut_3);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_encoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("encoding", "encoding", "java.lang.String", listType, this, false, false, true, "UTF-8",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("encoding", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setEncoding((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("encoding", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getEncoding();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_formatter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("formatter", "formatter", "java.lang.String", listType, this, false, false, true,
//                        "%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n", label, true, "FREE_FORM_TEXT_BOX", "FREE_FORM_TEXT_BOX",
//                        subgroup, tabName, 100, acceptedValues));
//        mut_3.register("formatter", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setFormatter((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("formatter", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getFormatter();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_append();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("append", "append", "java.lang.Boolean", listType, this, false, false, true, "true", label,
//                        false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("append", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setAppend((java.lang.Boolean) value);
//            }
//        });
//
//        mut_3.register("append", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.isAppend();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_autoFlush();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("autoFlush", "autoflush", "java.lang.Boolean", listType, this, false, false, true, "true",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("autoFlush", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setAutoFlush((java.lang.Boolean) value);
//            }
//        });
//
//        mut_3.register("autoFlush", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.isAutoFlush();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_filePath();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("filePath", "file/path", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_3.register("filePath", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setFilePath((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("filePath", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getFilePath();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_fileRelativeTo();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class).add(
//                new PropertyBinding("fileRelativeTo", "file/relative-to", "java.lang.String", listType, this, false, false,
//                        true, "jboss.server.log.dir", label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_3.register("fileRelativeTo", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity, Object value) {
//                entity.setFileRelativeTo((java.lang.String) value);
//            }
//        });
//
//        mut_3.register("fileRelativeTo", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler entity) {
//                return entity.getFileRelativeTo();
//            }
//        });
//
//        AddressBinding addr_3 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class, addr_3);
//        addr_3.add("subsystem", "logging");
//        addr_3.add("file-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.FileHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.FileHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.FileHandler create() {
//                        return beanFactory.fileHandler().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.FileHandler ----
//    }
//
//    public void Host_4() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.domain.model.Host.class, new ArrayList<PropertyBinding>());
//        Mutator mut_4 = new Mutator<org.jboss.as.console.client.domain.model.Host>();
//        mutators.put(org.jboss.as.console.client.domain.model.Host.class, mut_4);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Host.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_4.register("name", new Setter<org.jboss.as.console.client.domain.model.Host>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Host entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_4.register("name", new Getter<org.jboss.as.console.client.domain.model.Host>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Host entity) {
//                return entity.getName();
//            }
//        });
//
//        AddressBinding addr_4 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.domain.model.Host.class, addr_4);
//        factories.put(org.jboss.as.console.client.domain.model.Host.class,
//                new EntityFactory<org.jboss.as.console.client.domain.model.Host>() {
//                    public org.jboss.as.console.client.domain.model.Host create() {
//                        return beanFactory.host().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.domain.model.Host ----
//    }
//
//    public void Server_5() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.domain.model.Server.class, new ArrayList<PropertyBinding>());
//        Mutator mut_5 = new Mutator<org.jboss.as.console.client.domain.model.Server>();
//        mutators.put(org.jboss.as.console.client.domain.model.Server.class, mut_5);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Server.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_5.register("name", new Setter<org.jboss.as.console.client.domain.model.Server>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Server entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_5.register("name", new Getter<org.jboss.as.console.client.domain.model.Server>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Server entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Server.class).add(
//                new PropertyBinding("group", "group", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_5.register("group", new Setter<org.jboss.as.console.client.domain.model.Server>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Server entity, Object value) {
//                entity.setGroup((java.lang.String) value);
//            }
//        });
//
//        mut_5.register("group", new Getter<org.jboss.as.console.client.domain.model.Server>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Server entity) {
//                return entity.getGroup();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Server.class).add(
//                new PropertyBinding("socketBinding", "socket-binding-group", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_5.register("socketBinding", new Setter<org.jboss.as.console.client.domain.model.Server>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Server entity, Object value) {
//                entity.setSocketBinding((java.lang.String) value);
//            }
//        });
//
//        mut_5.register("socketBinding", new Getter<org.jboss.as.console.client.domain.model.Server>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Server entity) {
//                return entity.getSocketBinding();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Server.class).add(
//                new PropertyBinding("portOffset", "socket-binding-port-offset", "java.lang.Integer", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_5.register("portOffset", new Setter<org.jboss.as.console.client.domain.model.Server>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Server entity, Object value) {
//                entity.setPortOffset((java.lang.Integer) value);
//            }
//        });
//
//        mut_5.register("portOffset", new Getter<org.jboss.as.console.client.domain.model.Server>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Server entity) {
//                return entity.getPortOffset();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.Server.class).add(
//                new PropertyBinding("autoStart", "auto-start", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_5.register("autoStart", new Setter<org.jboss.as.console.client.domain.model.Server>() {
//            public void invoke(org.jboss.as.console.client.domain.model.Server entity, Object value) {
//                entity.setAutoStart((java.lang.Boolean) value);
//            }
//        });
//
//        mut_5.register("autoStart", new Getter<org.jboss.as.console.client.domain.model.Server>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.Server entity) {
//                return entity.isAutoStart();
//            }
//        });
//
//        AddressBinding addr_5 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.domain.model.Server.class, addr_5);
//        factories.put(org.jboss.as.console.client.domain.model.Server.class,
//                new EntityFactory<org.jboss.as.console.client.domain.model.Server>() {
//                    public org.jboss.as.console.client.domain.model.Server create() {
//                        return beanFactory.server().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.domain.model.Server ----
//    }
//
//    public void Logger_6() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class, new ArrayList<PropertyBinding>());
//        Mutator mut_6 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.Logger>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class, mut_6);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class).add(
//                new PropertyBinding("name", "category", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_6.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_6.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_handlers();
//        listType = java.lang.String.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class).add(
//                new PropertyBinding("handlers", "handlers", "java.util.List", listType, this, false, false, true, "", label,
//                        false, "STRING_LIST_EDITOR", "STRING_LIST_EDITOR", subgroup, tabName, 100, acceptedValues));
//        mut_6.register("handlers", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity, Object value) {
//                entity.setHandlers((java.util.List) value);
//            }
//        });
//
//        mut_6.register("handlers", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity) {
//                return entity.getHandlers();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_6.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_6.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_useParentHandlers();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class).add(
//                new PropertyBinding("useParentHandlers", "use-parent-handlers", "java.lang.Boolean", listType, this, false,
//                        false, true, "true", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_6.register("useParentHandlers", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity, Object value) {
//                entity.setUseParentHandlers((java.lang.Boolean) value);
//            }
//        });
//
//        mut_6.register("useParentHandlers", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.Logger entity) {
//                return entity.isUseParentHandlers();
//            }
//        });
//
//        AddressBinding addr_6 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class, addr_6);
//        addr_6.add("subsystem", "logging");
//        addr_6.add("logger", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.Logger.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.Logger>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.Logger create() {
//                        return beanFactory.logger().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.Logger ----
//    }
//
//    public void RootLogger_7() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class, new ArrayList<PropertyBinding>());
//        Mutator mut_7 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class, mut_7);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_7.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_7.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_handlers();
//        listType = java.lang.String.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class).add(
//                new PropertyBinding("handlers", "handlers", "java.util.List", listType, this, false, false, true, "", label,
//                        false, "STRING_LIST_EDITOR", "STRING_LIST_EDITOR", subgroup, tabName, 100, acceptedValues));
//        mut_7.register("handlers", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity, Object value) {
//                entity.setHandlers((java.util.List) value);
//            }
//        });
//
//        mut_7.register("handlers", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity) {
//                return entity.getHandlers();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_7.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_7.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger entity) {
//                return entity.getLevel();
//            }
//        });
//
//        AddressBinding addr_7 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class, addr_7);
//        addr_7.add("subsystem", "logging");
//        addr_7.add("root-logger", "ROOT");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.RootLogger.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.RootLogger>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.RootLogger create() {
//                        return beanFactory.rootLogger().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.RootLogger ----
//    }
//
//    public void PropertyRecord_8() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.properties.PropertyRecord.class, new ArrayList<PropertyBinding>());
//        Mutator mut_8 = new Mutator<org.jboss.as.console.client.shared.properties.PropertyRecord>();
//        mutators.put(org.jboss.as.console.client.shared.properties.PropertyRecord.class, mut_8);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.properties.PropertyRecord.class).add(
//                new PropertyBinding("value", "value", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_8.register("value", new Setter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity, Object value) {
//                entity.setValue((java.lang.String) value);
//            }
//        });
//
//        mut_8.register("value", new Getter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity) {
//                return entity.getValue();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.properties.PropertyRecord.class).add(
//                new PropertyBinding("key", "name", "java.lang.String", listType, this, false, false, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_8.register("key", new Setter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity, Object value) {
//                entity.setKey((java.lang.String) value);
//            }
//        });
//
//        mut_8.register("key", new Getter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity) {
//                return entity.getKey();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.properties.PropertyRecord.class).add(
//                new PropertyBinding("bootTime", "bootTime", "java.lang.Boolean", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_8.register("bootTime", new Setter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity, Object value) {
//                entity.setBootTime((java.lang.Boolean) value);
//            }
//        });
//
//        mut_8.register("bootTime", new Getter<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.properties.PropertyRecord entity) {
//                return entity.isBootTime();
//            }
//        });
//
//        AddressBinding addr_8 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.properties.PropertyRecord.class, addr_8);
//        factories.put(org.jboss.as.console.client.shared.properties.PropertyRecord.class,
//                new EntityFactory<org.jboss.as.console.client.shared.properties.PropertyRecord>() {
//                    public org.jboss.as.console.client.shared.properties.PropertyRecord create() {
//                        return beanFactory.property().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.properties.PropertyRecord ----
//    }
//
//    public void RemoteService_9() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class, new ArrayList<PropertyBinding>());
//        Mutator mut_9 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class, mut_9);
//        label = Console.CONSTANTS.subsys_ejb3_remoteServiceConnector();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class).add(
//                new PropertyBinding("connector", "connector-ref", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 20, acceptedValues));
//        mut_9.register("connector", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService entity, Object value) {
//                entity.setConnector((java.lang.String) value);
//            }
//        });
//
//        mut_9.register("connector", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService entity) {
//                return entity.getConnector();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_threadPool();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class).add(
//                new PropertyBinding("threadPoolName", "thread-pool-name", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "COMBO_BOX", "TEXT_BOX", subgroup, tabName, 10, acceptedValues));
//        mut_9.register("threadPoolName", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService entity, Object value) {
//                entity.setThreadPoolName((java.lang.String) value);
//            }
//        });
//
//        mut_9.register("threadPoolName", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService entity) {
//                return entity.getThreadPoolName();
//            }
//        });
//
//        AddressBinding addr_9 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class, addr_9);
//        addr_9.add("subsystem", "ejb3");
//        addr_9.add("service", "remote");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService create() {
//                        return beanFactory.remoteService().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.RemoteService ----
//    }
//
//    public void SubsystemRecord_10() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.model.SubsystemRecord.class, new ArrayList<PropertyBinding>());
//        Mutator mut_10 = new Mutator<org.jboss.as.console.client.shared.model.SubsystemRecord>();
//        mutators.put(org.jboss.as.console.client.shared.model.SubsystemRecord.class, mut_10);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.SubsystemRecord.class).add(
//                new PropertyBinding("key", "key", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_10.register("key", new Setter<org.jboss.as.console.client.shared.model.SubsystemRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.SubsystemRecord entity, Object value) {
//                entity.setKey((java.lang.String) value);
//            }
//        });
//
//        mut_10.register("key", new Getter<org.jboss.as.console.client.shared.model.SubsystemRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.SubsystemRecord entity) {
//                return entity.getKey();
//            }
//        });
//
//        AddressBinding addr_10 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.model.SubsystemRecord.class, addr_10);
//        factories.put(org.jboss.as.console.client.shared.model.SubsystemRecord.class,
//                new EntityFactory<org.jboss.as.console.client.shared.model.SubsystemRecord>() {
//                    public org.jboss.as.console.client.shared.model.SubsystemRecord create() {
//                        return beanFactory.subsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.model.SubsystemRecord ----
//    }
//
//    public void CommonSettings_11() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.core.settings.CommonSettings.class, new ArrayList<PropertyBinding>());
//        Mutator mut_11 = new Mutator<org.jboss.as.console.client.core.settings.CommonSettings>();
//        mutators.put(org.jboss.as.console.client.core.settings.CommonSettings.class, mut_11);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.core.settings.CommonSettings.class).add(
//                new PropertyBinding("locale", "locale", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_11.register("locale", new Setter<org.jboss.as.console.client.core.settings.CommonSettings>() {
//            public void invoke(org.jboss.as.console.client.core.settings.CommonSettings entity, Object value) {
//                entity.setLocale((java.lang.String) value);
//            }
//        });
//
//        mut_11.register("locale", new Getter<org.jboss.as.console.client.core.settings.CommonSettings>() {
//            public Object invoke(org.jboss.as.console.client.core.settings.CommonSettings entity) {
//                return entity.getLocale();
//            }
//        });
//
//        AddressBinding addr_11 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.core.settings.CommonSettings.class, addr_11);
//        factories.put(org.jboss.as.console.client.core.settings.CommonSettings.class,
//                new EntityFactory<org.jboss.as.console.client.core.settings.CommonSettings>() {
//                    public org.jboss.as.console.client.core.settings.CommonSettings create() {
//                        return beanFactory.settings().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.core.settings.CommonSettings ----
//    }
//
//    public void JSPContainerConfiguration_12() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_12 = new Mutator<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class, mut_12);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("checkInterval", "check-interval", "java.lang.Integer", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("checkInterval",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setCheckInterval((java.lang.Integer) value);
//                    }
//                });
//
//        mut_12.register("checkInterval",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.getCheckInterval();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("disabled", "disabled", "java.lang.Boolean", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("disabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setDisabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_12.register("disabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.isDisabled();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("development", "development", "java.lang.Boolean", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("development",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setDevelopment((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_12.register("development",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.isDevelopment();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("displaySource", "display-source-fragment", "java.lang.Boolean", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("displaySource",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setDisplaySource((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_12.register("displaySource",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.isDisplaySource();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("keepGenerated", "keep-generated", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("keepGenerated",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setKeepGenerated((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_12.register("keepGenerated",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.isKeepGenerated();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class).add(
//                new PropertyBinding("recompile", "recompile-on-fail", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_12.register("recompile",
//                new Setter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity,
//                            Object value) {
//                        entity.setRecompile((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_12.register("recompile",
//                new Getter<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration entity) {
//                        return entity.isRecompile();
//                    }
//                });
//
//        AddressBinding addr_12 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class, addr_12);
//        addr_12.add("subsystem", "web");
//        addr_12.add("configuration", "jsp-configuration");
//        factories.put(org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration>() {
//                    public org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration create() {
//                        return beanFactory.jspConfig().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.web.model.JSPContainerConfiguration ----
//    }
//
//    public void Topic_13() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.Topic.class, new ArrayList<PropertyBinding>());
//        Mutator mut_13 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.Topic>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.Topic.class, mut_13);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.Topic.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_13.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.Topic>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Topic entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_13.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.Topic>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.Topic entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        AddressBinding addr_13 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.Topic.class, addr_13);
//        addr_13.add("subsystem", "messaging");
//        addr_13.add("hornetq-server", "{0}");
//        addr_13.add("jms-topic", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.Topic.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.Topic>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.Topic create() {
//                        return beanFactory.topic().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.Topic ----
//    }
//
//    public void JPADeployment_14() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment.class, new ArrayList<PropertyBinding>());
//        Mutator mut_14 = new Mutator<org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment>();
//        mutators.put(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment.class, mut_14);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment.class).add(
//                new PropertyBinding("metricEnabled", "enabled", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_14.register("metricEnabled", new Setter<org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment>() {
//            public void invoke(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment entity, Object value) {
//                entity.setMetricEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_14.register("metricEnabled", new Getter<org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment>() {
//            public Object invoke(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment entity) {
//                return entity.isMetricEnabled();
//            }
//        });
//
//        AddressBinding addr_14 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment.class, addr_14);
//        factories.put(org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment.class,
//                new EntityFactory<org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment>() {
//                    public org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment create() {
//                        return beanFactory.jpaDeployment().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.runtime.jpa.model.JPADeployment ----
//    }
//
//    public void DeploymentRecord_15() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.model.DeploymentRecord.class, new ArrayList<PropertyBinding>());
//        Mutator mut_15 = new Mutator<org.jboss.as.console.client.shared.model.DeploymentRecord>();
//        mutators.put(org.jboss.as.console.client.shared.model.DeploymentRecord.class, mut_15);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.DeploymentRecord.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_15.register("name", new Setter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_15.register("name", new Getter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.DeploymentRecord.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_15.register("enabled", new Setter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_15.register("enabled", new Getter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.DeploymentRecord.class).add(
//                new PropertyBinding("serverGroup", "serverGroup", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_15.register("serverGroup", new Setter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity, Object value) {
//                entity.setServerGroup((java.lang.String) value);
//            }
//        });
//
//        mut_15.register("serverGroup", new Getter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity) {
//                return entity.getServerGroup();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.DeploymentRecord.class).add(
//                new PropertyBinding("runtimeName", "runtimeName", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_15.register("runtimeName", new Setter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity, Object value) {
//                entity.setRuntimeName((java.lang.String) value);
//            }
//        });
//
//        mut_15.register("runtimeName", new Getter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity) {
//                return entity.getRuntimeName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.model.DeploymentRecord.class).add(
//                new PropertyBinding("sha", "sha", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_15.register("sha", new Setter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public void invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity, Object value) {
//                entity.setSha((java.lang.String) value);
//            }
//        });
//
//        mut_15.register("sha", new Getter<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//            public Object invoke(org.jboss.as.console.client.shared.model.DeploymentRecord entity) {
//                return entity.getSha();
//            }
//        });
//
//        AddressBinding addr_15 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.model.DeploymentRecord.class, addr_15);
//        factories.put(org.jboss.as.console.client.shared.model.DeploymentRecord.class,
//                new EntityFactory<org.jboss.as.console.client.shared.model.DeploymentRecord>() {
//                    public org.jboss.as.console.client.shared.model.DeploymentRecord create() {
//                        return beanFactory.deployment().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.model.DeploymentRecord ----
//    }
//
//    public void WebServiceEndpoint_16() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_16 = new Mutator<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class, mut_16);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_16.register("name", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_16.register("name", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class).add(
//                new PropertyBinding("context", "context", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_16.register("context", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity, Object value) {
//                entity.setContext((java.lang.String) value);
//            }
//        });
//
//        mut_16.register("context", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity) {
//                return entity.getContext();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class).add(
//                new PropertyBinding("type", "type", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_16.register("type", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity, Object value) {
//                entity.setType((java.lang.String) value);
//            }
//        });
//
//        mut_16.register("type", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity) {
//                return entity.getType();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class).add(
//                new PropertyBinding("className", "className", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_16.register("className", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity, Object value) {
//                entity.setClassName((java.lang.String) value);
//            }
//        });
//
//        mut_16.register("className", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity) {
//                return entity.getClassName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class).add(
//                new PropertyBinding("wsdl", "wsdl-url", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_16.register("wsdl", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity, Object value) {
//                entity.setWsdl((java.lang.String) value);
//            }
//        });
//
//        mut_16.register("wsdl", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint entity) {
//                return entity.getWsdl();
//            }
//        });
//
//        AddressBinding addr_16 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class, addr_16);
//        factories.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint>() {
//                    public org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint create() {
//                        return beanFactory.webServiceEndpoint().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ws.model.WebServiceEndpoint ----
//    }
//
//    public void Module_17() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class, new ArrayList<PropertyBinding>());
//        Mutator mut_17 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class, mut_17);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_17.register("name", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.Module entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_17.register("name", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.Module entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class).add(
//                new PropertyBinding("slot", "slot", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_17.register("slot", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.Module entity, Object value) {
//                entity.setSlot((java.lang.String) value);
//            }
//        });
//
//        mut_17.register("slot", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.Module entity) {
//                return entity.getSlot();
//            }
//        });
//
//        AddressBinding addr_17 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class, addr_17);
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.Module.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.Module>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.Module create() {
//                        return beanFactory.eeModuleRef().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.Module ----
//    }
//
//    public void Jvm_18() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.jvm.Jvm.class, new ArrayList<PropertyBinding>());
//        Mutator mut_18 = new Mutator<org.jboss.as.console.client.shared.jvm.Jvm>();
//        mutators.put(org.jboss.as.console.client.shared.jvm.Jvm.class, mut_18);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("debugEnabled", "debug-enabled", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("debugEnabled", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setDebugEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_18.register("debugEnabled", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.isDebugEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("debugOptions", "debug-options", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("debugOptions", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setDebugOptions((java.lang.String) value);
//            }
//        });
//
//        mut_18.register("debugOptions", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.getDebugOptions();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("heapSize", "heap-size", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("heapSize", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setHeapSize((java.lang.String) value);
//            }
//        });
//
//        mut_18.register("heapSize", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.getHeapSize();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("maxHeapSize", "max-heap-size", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("maxHeapSize", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setMaxHeapSize((java.lang.String) value);
//            }
//        });
//
//        mut_18.register("maxHeapSize", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.getMaxHeapSize();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("maxPermgen", "max-permgen-size", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("maxPermgen", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setMaxPermgen((java.lang.String) value);
//            }
//        });
//
//        mut_18.register("maxPermgen", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.getMaxPermgen();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.Jvm.class).add(
//                new PropertyBinding("permgen", "permgen-size", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_18.register("permgen", new Setter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.Jvm entity, Object value) {
//                entity.setPermgen((java.lang.String) value);
//            }
//        });
//
//        mut_18.register("permgen", new Getter<org.jboss.as.console.client.shared.jvm.Jvm>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.Jvm entity) {
//                return entity.getPermgen();
//            }
//        });
//
//        AddressBinding addr_18 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.jvm.Jvm.class, addr_18);
//        factories.put(org.jboss.as.console.client.shared.jvm.Jvm.class,
//                new EntityFactory<org.jboss.as.console.client.shared.jvm.Jvm>() {
//                    public org.jboss.as.console.client.shared.jvm.Jvm create() {
//                        return beanFactory.jvm().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.jvm.Jvm ----
//    }
//
//    public void WorkmanagerPool_19() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_19 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class, mut_19);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_19.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_19.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Queue Length";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("queueLength", "queue-length", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("queueLength", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setQueueLength((java.lang.Integer) value);
//            }
//        });
//
//        mut_19.register("queueLength", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getQueueLength();
//            }
//        });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("maxThreads", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setMaxThreads((java.lang.Integer) value);
//            }
//        });
//
//        mut_19.register("maxThreads", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getMaxThreads();
//            }
//        });
//
//        label = "Allow Core Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("allowCoreTimeout", "allow-core-timeout", "java.lang.Boolean", listType, this, false,
//                        false, true, "true", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("allowCoreTimeout", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setAllowCoreTimeout((java.lang.Boolean) value);
//            }
//        });
//
//        mut_19.register("allowCoreTimeout", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.isAllowCoreTimeout();
//            }
//        });
//
//        label = "Core Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("coreThreads", "core-threads", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("coreThreads", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setCoreThreads((java.lang.Integer) value);
//            }
//        });
//
//        mut_19.register("coreThreads", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getCoreThreads();
//            }
//        });
//
//        label = "Keepalive Time";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("keepaliveTime", "keepalive-time/time", "java.lang.Long", listType, this, false, false,
//                        true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("keepaliveTime", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setKeepaliveTime((java.lang.Long) value);
//            }
//        });
//
//        mut_19.register("keepaliveTime", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getKeepaliveTime();
//            }
//        });
//
//        label = "Handoff Executor";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("handoffExecutor", "handoff-executor", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("handoffExecutor", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setHandoffExecutor((java.lang.String) value);
//            }
//        });
//
//        mut_19.register("handoffExecutor", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getHandoffExecutor();
//            }
//        });
//
//        label = "Keepalive Time Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class)
//                .add(new PropertyBinding("keepaliveTimeUnit", "keepalive-time/unit", "java.lang.String", listType, this, false,
//                        false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("keepaliveTimeUnit", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setKeepaliveTimeUnit((java.lang.String) value);
//            }
//        });
//
//        mut_19.register("keepaliveTimeUnit", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getKeepaliveTimeUnit();
//            }
//        });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_19.register("threadFactory", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity, Object value) {
//                entity.setThreadFactory((java.lang.String) value);
//            }
//        });
//
//        mut_19.register("threadFactory", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool entity) {
//                return entity.getThreadFactory();
//            }
//        });
//
//        AddressBinding addr_19 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class, addr_19);
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool create() {
//                        return beanFactory.WorkmanagerPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.WorkmanagerPool ----
//    }
//
//    public void CustomHandler_20() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_20 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class, mut_20);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_20.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_handlerProperties();
//        listType = org.jboss.as.console.client.shared.properties.PropertyRecord.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, true, "",
//                        label, false, "PROPERTY_EDITOR", "PROPERTY_EDITOR", subgroup, tabName, 100, acceptedValues));
//        mut_20.register("properties", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setProperties((java.util.List) value);
//            }
//        });
//
//        mut_20.register("properties", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getProperties();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_className();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("className", "class", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT", "TEXT_BOX", subgroup, tabName, 501, acceptedValues));
//        mut_20.register("className", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setClassName((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("className", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getClassName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_encoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("encoding", "encoding", "java.lang.String", listType, this, false, false, true, "UTF-8",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_20.register("encoding", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setEncoding((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("encoding", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getEncoding();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_formatter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("formatter", "formatter", "java.lang.String", listType, this, false, false, true,
//                        "%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n", label, false, "FREE_FORM_TEXT_BOX", "FREE_FORM_TEXT_BOX",
//                        subgroup, tabName, 100, acceptedValues));
//        mut_20.register("formatter", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setFormatter((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("formatter", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getFormatter();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_20.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_module();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class).add(
//                new PropertyBinding("module", "module", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT", "TEXT_BOX", subgroup, tabName, 500, acceptedValues));
//        mut_20.register("module", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity, Object value) {
//                entity.setModule((java.lang.String) value);
//            }
//        });
//
//        mut_20.register("module", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler entity) {
//                return entity.getModule();
//            }
//        });
//
//        AddressBinding addr_20 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class, addr_20);
//        addr_20.add("subsystem", "logging");
//        addr_20.add("custom-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler create() {
//                        return beanFactory.customHandler().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.CustomHandler ----
//    }
//
//    public void SocketBinding_21() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.general.model.SocketBinding.class, new ArrayList<PropertyBinding>());
//        Mutator mut_21 = new Mutator<org.jboss.as.console.client.shared.general.model.SocketBinding>();
//        mutators.put(org.jboss.as.console.client.shared.general.model.SocketBinding.class, mut_21);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("name", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_21.register("name", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("port", "port", "java.lang.Integer", listType, this, false, true, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("port", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setPort((java.lang.Integer) value);
//            }
//        });
//
//        mut_21.register("port", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getPort();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("group", "group", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("group", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setGroup((java.lang.String) value);
//            }
//        });
//
//        mut_21.register("group", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getGroup();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("fixedPort", "fixed-port", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("fixedPort", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setFixedPort((java.lang.Boolean) value);
//            }
//        });
//
//        mut_21.register("fixedPort", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.isFixedPort();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("multiCastPort", "multicast-port", "java.lang.Integer", listType, this, false, true, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("multiCastPort", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setMultiCastPort((java.lang.Integer) value);
//            }
//        });
//
//        mut_21.register("multiCastPort", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getMultiCastPort();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("interface", "interface", "java.lang.String", listType, this, false, true, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("interface", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setInterface((java.lang.String) value);
//            }
//        });
//
//        mut_21.register("interface", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getInterface();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketBinding.class).add(
//                new PropertyBinding("multiCastAddress", "multicast-address", "java.lang.String", listType, this, false, true,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_21.register("multiCastAddress", new Setter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity, Object value) {
//                entity.setMultiCastAddress((java.lang.String) value);
//            }
//        });
//
//        mut_21.register("multiCastAddress", new Getter<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketBinding entity) {
//                return entity.getMultiCastAddress();
//            }
//        });
//
//        AddressBinding addr_21 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.general.model.SocketBinding.class, addr_21);
//        factories.put(org.jboss.as.console.client.shared.general.model.SocketBinding.class,
//                new EntityFactory<org.jboss.as.console.client.shared.general.model.SocketBinding>() {
//                    public org.jboss.as.console.client.shared.general.model.SocketBinding create() {
//                        return beanFactory.socketBinding().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.general.model.SocketBinding ----
//    }
//
//    public void ServerGroupRecord_22() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.domain.model.ServerGroupRecord.class, new ArrayList<PropertyBinding>());
//        Mutator mut_22 = new Mutator<org.jboss.as.console.client.domain.model.ServerGroupRecord>();
//        mutators.put(org.jboss.as.console.client.domain.model.ServerGroupRecord.class, mut_22);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerGroupRecord.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_22.register("properties", new Setter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity, Object value) {
//                entity.setProperties((java.util.List) value);
//            }
//        });
//
//        mut_22.register("properties", new Getter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity) {
//                return entity.getProperties();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerGroupRecord.class).add(
//                new PropertyBinding("groupName", "groupName", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_22.register("groupName", new Setter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity, Object value) {
//                entity.setGroupName((java.lang.String) value);
//            }
//        });
//
//        mut_22.register("groupName", new Getter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity) {
//                return entity.getGroupName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerGroupRecord.class).add(
//                new PropertyBinding("socketBinding", "socket-binding-group", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_22.register("socketBinding", new Setter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity, Object value) {
//                entity.setSocketBinding((java.lang.String) value);
//            }
//        });
//
//        mut_22.register("socketBinding", new Getter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity) {
//                return entity.getSocketBinding();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerGroupRecord.class).add(
//                new PropertyBinding("profileName", "profile", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_22.register("profileName", new Setter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity, Object value) {
//                entity.setProfileName((java.lang.String) value);
//            }
//        });
//
//        mut_22.register("profileName", new Getter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity) {
//                return entity.getProfileName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerGroupRecord.class).add(
//                new PropertyBinding("jvm", "jvm", "org.jboss.as.console.client.shared.jvm.Jvm", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_22.register("jvm", new Setter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity, Object value) {
//                entity.setJvm((org.jboss.as.console.client.shared.jvm.Jvm) value);
//            }
//        });
//
//        mut_22.register("jvm", new Getter<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerGroupRecord entity) {
//                return entity.getJvm();
//            }
//        });
//
//        AddressBinding addr_22 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.domain.model.ServerGroupRecord.class, addr_22);
//        factories.put(org.jboss.as.console.client.domain.model.ServerGroupRecord.class,
//                new EntityFactory<org.jboss.as.console.client.domain.model.ServerGroupRecord>() {
//                    public org.jboss.as.console.client.domain.model.ServerGroupRecord create() {
//                        return beanFactory.serverGroup().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.domain.model.ServerGroupRecord ----
//    }
//
//    public void ServerInstance_23() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.domain.model.ServerInstance.class, new ArrayList<PropertyBinding>());
//        Mutator mut_23 = new Mutator<org.jboss.as.console.client.domain.model.ServerInstance>();
//        mutators.put(org.jboss.as.console.client.domain.model.ServerInstance.class, mut_23);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerInstance.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_23.register("name", new Setter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerInstance entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_23.register("name", new Getter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerInstance entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerInstance.class).add(
//                new PropertyBinding("server", "server", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_23.register("server", new Setter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerInstance entity, Object value) {
//                entity.setServer((java.lang.String) value);
//            }
//        });
//
//        mut_23.register("server", new Getter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerInstance entity) {
//                return entity.getServer();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerInstance.class).add(
//                new PropertyBinding("running", "running", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_23.register("running", new Setter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerInstance entity, Object value) {
//                entity.setRunning((java.lang.Boolean) value);
//            }
//        });
//
//        mut_23.register("running", new Getter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerInstance entity) {
//                return entity.isRunning();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerInstance.class).add(
//                new PropertyBinding("group", "group", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_23.register("group", new Setter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerInstance entity, Object value) {
//                entity.setGroup((java.lang.String) value);
//            }
//        });
//
//        mut_23.register("group", new Getter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerInstance entity) {
//                return entity.getGroup();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.domain.model.ServerInstance.class).add(
//                new PropertyBinding("flag", "flag", "org.jboss.as.console.client.domain.model.ServerFlag", listType, this,
//                        false, false, false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_23.register("flag", new Setter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public void invoke(org.jboss.as.console.client.domain.model.ServerInstance entity, Object value) {
//                entity.setFlag((org.jboss.as.console.client.domain.model.ServerFlag) value);
//            }
//        });
//
//        mut_23.register("flag", new Getter<org.jboss.as.console.client.domain.model.ServerInstance>() {
//            public Object invoke(org.jboss.as.console.client.domain.model.ServerInstance entity) {
//                return entity.getFlag();
//            }
//        });
//
//        AddressBinding addr_23 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.domain.model.ServerInstance.class, addr_23);
//        factories.put(org.jboss.as.console.client.domain.model.ServerInstance.class,
//                new EntityFactory<org.jboss.as.console.client.domain.model.ServerInstance>() {
//                    public org.jboss.as.console.client.domain.model.ServerInstance create() {
//                        return beanFactory.serverInstance().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.domain.model.ServerInstance ----
//    }
//
//    public void PoolConfig_24() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class, new ArrayList<PropertyBinding>());
//        Mutator mut_24 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class, mut_24);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_24.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_24.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class).add(
//                new PropertyBinding("maxPoolSize", "max-pool-size", "java.lang.Integer", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_24.register("maxPoolSize", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity, Object value) {
//                entity.setMaxPoolSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_24.register("maxPoolSize", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity) {
//                return entity.getMaxPoolSize();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class).add(
//                new PropertyBinding("poolPrefill", "pool-prefill", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_24.register("poolPrefill", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity, Object value) {
//                entity.setPoolPrefill((java.lang.Boolean) value);
//            }
//        });
//
//        mut_24.register("poolPrefill", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity) {
//                return entity.isPoolPrefill();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class).add(
//                new PropertyBinding("poolStrictMin", "pool-use-strict-min", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_24.register("poolStrictMin", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity, Object value) {
//                entity.setPoolStrictMin((java.lang.Boolean) value);
//            }
//        });
//
//        mut_24.register("poolStrictMin", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity) {
//                return entity.isPoolStrictMin();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class).add(
//                new PropertyBinding("minPoolSize", "min-pool-size", "java.lang.Integer", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_24.register("minPoolSize", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity, Object value) {
//                entity.setMinPoolSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_24.register("minPoolSize", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig entity) {
//                return entity.getMinPoolSize();
//            }
//        });
//
//        AddressBinding addr_24 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class, addr_24);
//        addr_24.add("subsystem", "datasources");
//        addr_24.add("{0}", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig create() {
//                        return beanFactory.poolConfig().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.PoolConfig ----
//    }
//
//    public void DataSource_25() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class, new ArrayList<PropertyBinding>());
//        Mutator mut_25 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class, mut_25);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("password", "password", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("password", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setPassword((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("password", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getPassword();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("driverName", "driver-name", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("driverName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setDriverName((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("driverName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getDriverName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_25.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("username", "user-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("username", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setUsername((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("username", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getUsername();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("securityDomain", "security-domain", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("securityDomain", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setSecurityDomain((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("securityDomain", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getSecurityDomain();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("poolName", "pool-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("poolName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setPoolName((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("poolName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getPoolName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("transactionIsolation", "transaction-isolation", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("transactionIsolation", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setTransactionIsolation((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("transactionIsolation", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getTransactionIsolation();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("connectionSql", "new-connection-sql", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("connectionSql", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setConnectionSql((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("connectionSql", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getConnectionSql();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("connectionUrl", "connection-url", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("connectionUrl", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setConnectionUrl((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("connectionUrl", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getConnectionUrl();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("driverClass", "driver-class", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("driverClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setDriverClass((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("driverClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getDriverClass();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("validConnectionChecker", "valid-connection-checker-class-name", "java.lang.String",
//                        listType, this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_25.register("validConnectionChecker", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setValidConnectionChecker((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("validConnectionChecker", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getValidConnectionChecker();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("checkValidSql", "check-valid-connection-sql", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("checkValidSql", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setCheckValidSql((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("checkValidSql", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getCheckValidSql();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("backgroundValidation", "background-validation", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("backgroundValidation", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setBackgroundValidation((java.lang.Boolean) value);
//            }
//        });
//
//        mut_25.register("backgroundValidation", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.isBackgroundValidation();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("backgroundValidationMillis", "background-validation-millis", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_25.register("backgroundValidationMillis",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                        entity.setBackgroundValidationMillis((java.lang.Long) value);
//                    }
//                });
//
//        mut_25.register("backgroundValidationMillis",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                        return entity.getBackgroundValidationMillis();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("validateOnMatch", "validate-on-match", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("validateOnMatch", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setValidateOnMatch((java.lang.Boolean) value);
//            }
//        });
//
//        mut_25.register("validateOnMatch", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.isValidateOnMatch();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("staleConnectionChecker", "stale-connection-checker-class-name", "java.lang.String",
//                        listType, this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_25.register("staleConnectionChecker", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setStaleConnectionChecker((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("staleConnectionChecker", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getStaleConnectionChecker();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("exceptionSorter", "exception-sorter-class-name", "java.lang.String", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("exceptionSorter", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setExceptionSorter((java.lang.String) value);
//            }
//        });
//
//        mut_25.register("exceptionSorter", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.getExceptionSorter();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("prepareStatementCacheSize", "prepared-statements-cache-size", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_25.register("prepareStatementCacheSize",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                        entity.setPrepareStatementCacheSize((java.lang.Long) value);
//                    }
//                });
//
//        mut_25.register("prepareStatementCacheSize",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                        return entity.getPrepareStatementCacheSize();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("sharePreparedStatements", "share-prepared-statements", "java.lang.Boolean", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_25.register("sharePreparedStatements",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                        entity.setSharePreparedStatements((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_25.register("sharePreparedStatements",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                        return entity.isSharePreparedStatements();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("jta", "jta", "java.lang.Boolean", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("jta", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setJta((java.lang.Boolean) value);
//            }
//        });
//
//        mut_25.register("jta", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.isJta();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class).add(
//                new PropertyBinding("ccm", "use-ccm", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_25.register("ccm", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity, Object value) {
//                entity.setCcm((java.lang.Boolean) value);
//            }
//        });
//
//        mut_25.register("ccm", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.DataSource entity) {
//                return entity.isCcm();
//            }
//        });
//
//        AddressBinding addr_25 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class, addr_25);
//        addr_25.add("subsystem", "datasources");
//        addr_25.add("data-source", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.DataSource.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.DataSource>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.DataSource create() {
//                        return beanFactory.dataSource().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.DataSource ----
//    }
//
//    public void CacheContainer_26() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_26 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class, mut_26);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Stack";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("stack", "transport/stack", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("stack", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setStack((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("stack", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getStack();
//            }
//        });
//
//        label = "Aliases";
//        listType = java.lang.String.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class)
//                .add(new PropertyBinding("aliases", "alias", "java.util.List", listType, this, false, false, true, "", label,
//                        false, "UNLIMITED_STRING_LIST_EDITOR", "UNLIMITED_STRING_LIST_EDITOR", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_26.register("aliases", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setAliases((java.util.List) value);
//            }
//        });
//
//        mut_26.register("aliases", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getAliases();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_infinispan_jndiName();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "Lock Timeout (ms)";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("lockTimeout", "transport/lock-timeout", "java.lang.Long", listType, this, false, false,
//                        true, "60000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("lockTimeout", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setLockTimeout((java.lang.Long) value);
//            }
//        });
//
//        mut_26.register("lockTimeout", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getLockTimeout();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_infinispan_default_cache();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("defaultCache", "default-cache", "java.lang.String", listType, this, false, false, true,
//                        "", label, true, "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("defaultCache",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity,
//                            Object value) {
//                        entity.setDefaultCache((java.lang.String) value);
//                    }
//                });
//
//        mut_26.register("defaultCache",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                        return entity.getDefaultCache();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_infinispan_evictionExecutor();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("evictionExecutor", "eviction-executor", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("evictionExecutor",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity,
//                            Object value) {
//                        entity.setEvictionExecutor((java.lang.String) value);
//                    }
//                });
//
//        mut_26.register("evictionExecutor",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                        return entity.getEvictionExecutor();
//                    }
//                });
//
//        label = "Executor";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("executor", "transport/executor", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("executor", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setExecutor((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("executor", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getExecutor();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_infinispan_listenerExecutor();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("listenerExecutor", "listener-executor", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("listenerExecutor",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity,
//                            Object value) {
//                        entity.setListenerExecutor((java.lang.String) value);
//                    }
//                });
//
//        mut_26.register("listenerExecutor",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                        return entity.getListenerExecutor();
//                    }
//                });
//
//        label = "Machine";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("machine", "transport/machine", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("machine", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setMachine((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("machine", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getMachine();
//            }
//        });
//
//        label = "Rack";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("rack", "transport/rack", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("rack", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setRack((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("rack", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getRack();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_infinispan_replicationQueueExecutor();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("replicationQueueExecutor", "replication-queue-executor", "java.lang.String", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_26.register("replicationQueueExecutor",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity,
//                            Object value) {
//                        entity.setReplicationQueueExecutor((java.lang.String) value);
//                    }
//                });
//
//        mut_26.register("replicationQueueExecutor",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                        return entity.getReplicationQueueExecutor();
//                    }
//                });
//
//        label = "Site";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_transport();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class).add(
//                new PropertyBinding("site", "transport/site", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_26.register("site", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity, Object value) {
//                entity.setSite((java.lang.String) value);
//            }
//        });
//
//        mut_26.register("site", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer entity) {
//                return entity.getSite();
//            }
//        });
//
//        AddressBinding addr_26 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class, addr_26);
//        addr_26.add("subsystem", "infinispan");
//        addr_26.add("cache-container", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer create() {
//                        return beanFactory.cacheContainer().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.CacheContainer ----
//    }
//
//    public void RuntimeMetric_27() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class, new ArrayList<PropertyBinding>());
//        Mutator mut_27 = new Mutator<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>();
//        mutators.put(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class, mut_27);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class).add(
//                new PropertyBinding("vmName", "vm-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_27.register("vmName", new Setter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity, Object value) {
//                entity.setVmName((java.lang.String) value);
//            }
//        });
//
//        mut_27.register("vmName", new Getter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity) {
//                return entity.getVmName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class).add(
//                new PropertyBinding("startTime", "start-time", "java.lang.Long", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_27.register("startTime", new Setter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity, Object value) {
//                entity.setStartTime((java.lang.Long) value);
//            }
//        });
//
//        mut_27.register("startTime", new Getter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity) {
//                return entity.getStartTime();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class).add(
//                new PropertyBinding("uptime", "uptime", "java.lang.Long", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_27.register("uptime", new Setter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity, Object value) {
//                entity.setUptime((java.lang.Long) value);
//            }
//        });
//
//        mut_27.register("uptime", new Getter<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric entity) {
//                return entity.getUptime();
//            }
//        });
//
//        AddressBinding addr_27 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class, addr_27);
//        factories.put(org.jboss.as.console.client.shared.jvm.model.RuntimeMetric.class,
//                new EntityFactory<org.jboss.as.console.client.shared.jvm.model.RuntimeMetric>() {
//                    public org.jboss.as.console.client.shared.jvm.model.RuntimeMetric create() {
//                        return beanFactory.runtime().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.jvm.model.RuntimeMetric ----
//    }
//
//    public void JMXSubsystem_28() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class, new ArrayList<PropertyBinding>());
//        Mutator mut_28 = new Mutator<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class, mut_28);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class).add(
//                new PropertyBinding("showModel", "show-model", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_28.register("showModel", new Setter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity, Object value) {
//                entity.setShowModel((java.lang.Boolean) value);
//            }
//        });
//
//        mut_28.register("showModel", new Getter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity) {
//                return entity.isShowModel();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class).add(
//                new PropertyBinding("registryBinding", "registry-binding", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_28.register("registryBinding", new Setter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity, Object value) {
//                entity.setRegistryBinding((java.lang.String) value);
//            }
//        });
//
//        mut_28.register("registryBinding", new Getter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity) {
//                return entity.getRegistryBinding();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class).add(
//                new PropertyBinding("serverBinding", "server-binding", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_28.register("serverBinding", new Setter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity, Object value) {
//                entity.setServerBinding((java.lang.String) value);
//            }
//        });
//
//        mut_28.register("serverBinding", new Getter<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem entity) {
//                return entity.getServerBinding();
//            }
//        });
//
//        AddressBinding addr_28 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class, addr_28);
//        addr_28.add("subsystem", "jmx");
//        factories.put(org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem create() {
//                        return beanFactory.jmxSubsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jmx.model.JMXSubsystem ----
//    }
//
//    public void EESubsystem_29() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem.class, new ArrayList<PropertyBinding>());
//        Mutator mut_29 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem.class, mut_29);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem.class).add(
//                new PropertyBinding("isolatedSubdeployments", "ear-subdeployments-isolated", "java.lang.Boolean", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_29.register("isolatedSubdeployments",
//                new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem entity, Object value) {
//                        entity.setIsolatedSubdeployments((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_29.register("isolatedSubdeployments",
//                new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem entity) {
//                        return entity.isIsolatedSubdeployments();
//                    }
//                });
//
//        AddressBinding addr_29 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem.class, addr_29);
//        addr_29.add("subsystem", "ee");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem create() {
//                        return beanFactory.eeSubsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.EESubsystem ----
//    }
//
//    public void XADataSource_30() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class, new ArrayList<PropertyBinding>());
//        Mutator mut_30 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class, mut_30);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("dataSourceClass", "xa-data-source-class", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("dataSourceClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setDataSourceClass((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("dataSourceClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getDataSourceClass();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("padXid", "pad-xid", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("padXid", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setPadXid((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("padXid", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isPadXid();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("wrapXaResource", "wrap-xa-resource", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("wrapXaResource", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setWrapXaResource((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("wrapXaResource", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isWrapXaResource();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("enableRMOverride", "same-rm-override", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("enableRMOverride", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setEnableRMOverride((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("enableRMOverride", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isEnableRMOverride();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("enableInterleave", "interleaving", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("enableInterleave", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setEnableInterleave((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("enableInterleave", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isEnableInterleave();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("password", "password", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("password", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setPassword((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("password", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getPassword();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("driverName", "driver-name", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("driverName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setDriverName((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("driverName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getDriverName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("username", "user-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("username", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setUsername((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("username", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getUsername();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("securityDomain", "security-domain", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("securityDomain", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setSecurityDomain((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("securityDomain", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getSecurityDomain();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("poolName", "pool-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("poolName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setPoolName((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("poolName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getPoolName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("transactionIsolation", "transaction-isolation", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("transactionIsolation", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setTransactionIsolation((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("transactionIsolation", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getTransactionIsolation();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("connectionSql", "new-connection-sql", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("connectionSql", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setConnectionSql((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("connectionSql", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getConnectionSql();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("connectionUrl", "connection-url", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("connectionUrl", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setConnectionUrl((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("connectionUrl", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getConnectionUrl();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("driverClass", "driver-class", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("driverClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setDriverClass((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("driverClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getDriverClass();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("validConnectionChecker", "valid-connection-checker-class-name", "java.lang.String",
//                        listType, this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_30.register("validConnectionChecker",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                        entity.setValidConnectionChecker((java.lang.String) value);
//                    }
//                });
//
//        mut_30.register("validConnectionChecker",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                        return entity.getValidConnectionChecker();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("checkValidSql", "check-valid-connection-sql", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("checkValidSql", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setCheckValidSql((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("checkValidSql", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getCheckValidSql();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("backgroundValidation", "background-validation", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("backgroundValidation", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setBackgroundValidation((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("backgroundValidation", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isBackgroundValidation();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("backgroundValidationMillis", "background-validation-millis", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_30.register("backgroundValidationMillis",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                        entity.setBackgroundValidationMillis((java.lang.Long) value);
//                    }
//                });
//
//        mut_30.register("backgroundValidationMillis",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                        return entity.getBackgroundValidationMillis();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("validateOnMatch", "validate-on-match", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("validateOnMatch", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setValidateOnMatch((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("validateOnMatch", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isValidateOnMatch();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("staleConnectionChecker", "stale-connection-checker-class-name", "java.lang.String",
//                        listType, this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_30.register("staleConnectionChecker",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                        entity.setStaleConnectionChecker((java.lang.String) value);
//                    }
//                });
//
//        mut_30.register("staleConnectionChecker",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                        return entity.getStaleConnectionChecker();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("exceptionSorter", "exception-sorter-class-name", "java.lang.String", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("exceptionSorter", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setExceptionSorter((java.lang.String) value);
//            }
//        });
//
//        mut_30.register("exceptionSorter", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.getExceptionSorter();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("prepareStatementCacheSize", "prepared-statements-cache-size", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_30.register("prepareStatementCacheSize",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                        entity.setPrepareStatementCacheSize((java.lang.Long) value);
//                    }
//                });
//
//        mut_30.register("prepareStatementCacheSize",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                        return entity.getPrepareStatementCacheSize();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("sharePreparedStatements", "share-prepared-statements", "java.lang.Boolean", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_30.register("sharePreparedStatements",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                        entity.setSharePreparedStatements((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_30.register("sharePreparedStatements",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                        return entity.isSharePreparedStatements();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class).add(
//                new PropertyBinding("ccm", "use-ccm", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_30.register("ccm", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity, Object value) {
//                entity.setCcm((java.lang.Boolean) value);
//            }
//        });
//
//        mut_30.register("ccm", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource entity) {
//                return entity.isCcm();
//            }
//        });
//
//        AddressBinding addr_30 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class, addr_30);
//        addr_30.add("subsystem", "datasources");
//        addr_30.add("xa-data-source", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.XADataSource.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.XADataSource>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.XADataSource create() {
//                        return beanFactory.xaDataSource().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.XADataSource ----
//    }
//
//    public void ResourceAdapter_31() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_31 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class, mut_31);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class).add(
//                new PropertyBinding("archive", "archive", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_31.register("archive", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity, Object value) {
//                entity.setArchive((java.lang.String) value);
//            }
//        });
//
//        mut_31.register("archive", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity) {
//                return entity.getArchive();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class).add(
//                new PropertyBinding("transactionSupport", "transaction-support", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_31.register("transactionSupport",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity, Object value) {
//                        entity.setTransactionSupport((java.lang.String) value);
//                    }
//                });
//
//        mut_31.register("transactionSupport",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity) {
//                        return entity.getTransactionSupport();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class).add(
//                new PropertyBinding("connectionDefinitions", "connectionDefinitions", "java.util.List", listType, this, false,
//                        false, false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_31.register("connectionDefinitions",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity, Object value) {
//                        entity.setConnectionDefinitions((java.util.List) value);
//                    }
//                });
//
//        mut_31.register("connectionDefinitions",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter entity) {
//                        return entity.getConnectionDefinitions();
//                    }
//                });
//
//        AddressBinding addr_31 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class, addr_31);
//        addr_31.add("subsystem", "resource-adapters");
//        addr_31.add("resource-adapter", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter create() {
//                        return beanFactory.resourceAdapter().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.ResourceAdapter ----
//    }
//
//    public void ConnectionDefinition_32() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_32 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class, mut_32);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("application", "security-application", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("application", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity, Object value) {
//                entity.setApplication((java.lang.String) value);
//            }
//        });
//
//        mut_32.register("application", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                return entity.getApplication();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_32.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("securityDomain", "security-domain", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("securityDomain",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity,
//                            Object value) {
//                        entity.setSecurityDomain((java.lang.String) value);
//                    }
//                });
//
//        mut_32.register("securityDomain",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                        return entity.getSecurityDomain();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_32.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("backgroundValidation", "background-validation", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("backgroundValidation",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity,
//                            Object value) {
//                        entity.setBackgroundValidation((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_32.register("backgroundValidation",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                        return entity.isBackgroundValidation();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("backgroundValidationMillis", "background-validation-millis", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_32.register("backgroundValidationMillis",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity,
//                            Object value) {
//                        entity.setBackgroundValidationMillis((java.lang.Long) value);
//                    }
//                });
//
//        mut_32.register("backgroundValidationMillis",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                        return entity.getBackgroundValidationMillis();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("connectionClass", "class-name", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_32.register("connectionClass",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity,
//                            Object value) {
//                        entity.setConnectionClass((java.lang.String) value);
//                    }
//                });
//
//        mut_32.register("connectionClass",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                        return entity.getConnectionClass();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class).add(
//                new PropertyBinding("domainAndApplication", "security-domain-and-application", "java.lang.String", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_32.register("domainAndApplication",
//                new Setter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity,
//                            Object value) {
//                        entity.setDomainAndApplication((java.lang.String) value);
//                    }
//                });
//
//        mut_32.register("domainAndApplication",
//                new Getter<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition entity) {
//                        return entity.getDomainAndApplication();
//                    }
//                });
//
//        AddressBinding addr_32 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class, addr_32);
//        addr_32.add("subsystem", "resource-adapters");
//        addr_32.add("resource-adapter", "{0}");
//        addr_32.add("connection-definitions", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition create() {
//                        return beanFactory.ConnectionDefinition().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.ConnectionDefinition ----
//    }
//
//    public void AdminObject_33() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class, new ArrayList<PropertyBinding>());
//        Mutator mut_33 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class, mut_33);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_33.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_33.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_33.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_33.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class).add(
//                new PropertyBinding("useJavaContext", "use-java-context", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_33.register("useJavaContext", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity, Object value) {
//                entity.setUseJavaContext((java.lang.Boolean) value);
//            }
//        });
//
//        mut_33.register("useJavaContext", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity) {
//                return entity.isUseJavaContext();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class).add(
//                new PropertyBinding("adminClass", "class-name", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_33.register("adminClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity, Object value) {
//                entity.setAdminClass((java.lang.String) value);
//            }
//        });
//
//        mut_33.register("adminClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject entity) {
//                return entity.getAdminClass();
//            }
//        });
//
//        AddressBinding addr_33 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class, addr_33);
//        addr_33.add("subsystem", "resource-adapters");
//        addr_33.add("resource-adapter", "{0}");
//        addr_33.add("admin-objects", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.AdminObject.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.AdminObject>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.AdminObject create() {
//                        return beanFactory.AdminObject().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.AdminObject ----
//    }
//
//    public void ConnectionFactory_34() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_34 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class, mut_34);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_34.register("name", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_34.register("name", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class).add(
//                new PropertyBinding("jndiName", "jndiName", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_34.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_34.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        AddressBinding addr_34 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class, addr_34);
//        addr_34.add("subsystem", "messaging");
//        addr_34.add("hornetq-server", "{0}");
//        addr_34.add("connection-factory", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory create() {
//                        return beanFactory.connectionFactory().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.ConnectionFactory ----
//    }
//
//    public void EJB3Subsystem_35() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class, new ArrayList<PropertyBinding>());
//        Mutator mut_35 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class, mut_35);
//        label = Console.CONSTANTS.subsys_ejb3_messageDrivenBeanPool();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class).add(
//                new PropertyBinding("defaultMDBPool", "default-mdb-instance-pool", "java.lang.String", listType, this, false,
//                        false, true, "", label, true, "COMBO_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_35.register("defaultMDBPool", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity, Object value) {
//                entity.setDefaultMDBPool((java.lang.String) value);
//            }
//        });
//
//        mut_35.register("defaultMDBPool", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity) {
//                return entity.getDefaultMDBPool();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_defaultResourceAdapter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class).add(
//                new PropertyBinding("defaultRA", "default-resource-adapter-name", "java.lang.String", listType, this, false,
//                        false, true, "", label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_35.register("defaultRA", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity, Object value) {
//                entity.setDefaultRA((java.lang.String) value);
//            }
//        });
//
//        mut_35.register("defaultRA", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity) {
//                return entity.getDefaultRA();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_statelessSessionBeanPool();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class).add(
//                new PropertyBinding("defaultSLSBPool", "default-slsb-instance-pool", "java.lang.String", listType, this, false,
//                        false, true, "", label, true, "COMBO_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_35.register("defaultSLSBPool", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity, Object value) {
//                entity.setDefaultSLSBPool((java.lang.String) value);
//            }
//        });
//
//        mut_35.register("defaultSLSBPool", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity) {
//                return entity.getDefaultSLSBPool();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_singletonAccessTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class).add(
//                new PropertyBinding("defaultSingletonAccessTimeout", "default-singleton-bean-access-timeout", "java.lang.Long",
//                        listType, this, false, false, true, "", label, true, "NUMBER_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_35.register("defaultSingletonAccessTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity, Object value) {
//                        entity.setDefaultSingletonAccessTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_35.register("defaultSingletonAccessTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity) {
//                        return entity.getDefaultSingletonAccessTimeout();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_ejb3_statefulAccessTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class).add(
//                new PropertyBinding("defaultStatefulAccessTimeout", "default-stateful-bean-access-timeout", "java.lang.Long",
//                        listType, this, false, false, true, "", label, true, "NUMBER_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_35.register("defaultStatefulAccessTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity, Object value) {
//                        entity.setDefaultStatefulAccessTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_35.register("defaultStatefulAccessTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem entity) {
//                        return entity.getDefaultStatefulAccessTimeout();
//                    }
//                });
//
//        AddressBinding addr_35 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class, addr_35);
//        addr_35.add("subsystem", "ejb3");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem create() {
//                        return beanFactory.ejb3Subsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3Subsystem ----
//    }
//
//    public void StrictMaxBeanPool_36() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_36 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class, mut_36);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_36.register("name", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_36.register("name", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_beanPoolTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class).add(
//                new PropertyBinding("timeout", "timeout", "java.lang.Long", listType, this, false, false, false, "5", label,
//                        false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_36.register("timeout", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity, Object value) {
//                entity.setTimeout((java.lang.Long) value);
//            }
//        });
//
//        mut_36.register("timeout", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity) {
//                return entity.getTimeout();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_maxPoolSize();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class).add(
//                new PropertyBinding("maxPoolSize", "max-pool-size", "java.lang.Integer", listType, this, false, false, true,
//                        "20", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_36.register("maxPoolSize", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity, Object value) {
//                entity.setMaxPoolSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_36.register("maxPoolSize", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity) {
//                return entity.getMaxPoolSize();
//            }
//        });
//
//        label = "Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class).add(
//                new PropertyBinding("timeoutUnit", "timeout-unit", "java.lang.String", listType, this, false, false, true,
//                        "MINUTES", label, false, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100, acceptedValues));
//        mut_36.register("timeoutUnit", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity, Object value) {
//                entity.setTimeoutUnit((java.lang.String) value);
//            }
//        });
//
//        mut_36.register("timeoutUnit", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool entity) {
//                return entity.getTimeoutUnit();
//            }
//        });
//
//        AddressBinding addr_36 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class, addr_36);
//        addr_36.add("subsystem", "ejb3");
//        addr_36.add("strict-max-bean-instance-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool create() {
//                        return beanFactory.strictMaxBeanPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.StrictMaxBeanPool ----
//    }
//
//    public void AsyncService_37() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService.class, new ArrayList<PropertyBinding>());
//        Mutator mut_37 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService.class, mut_37);
//        label = Console.CONSTANTS.subsys_ejb3_threadPool();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService.class).add(
//                new PropertyBinding("threadPoolName", "thread-pool-name", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "COMBO_BOX", "TEXT_BOX", subgroup, tabName, 10, acceptedValues));
//        mut_37.register("threadPoolName", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService entity, Object value) {
//                entity.setThreadPoolName((java.lang.String) value);
//            }
//        });
//
//        mut_37.register("threadPoolName", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService entity) {
//                return entity.getThreadPoolName();
//            }
//        });
//
//        AddressBinding addr_37 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService.class, addr_37);
//        addr_37.add("subsystem", "ejb3");
//        addr_37.add("service", "async");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService create() {
//                        return beanFactory.asyncService().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.AsyncService ----
//    }
//
//    public void TimerService_38() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class, new ArrayList<PropertyBinding>());
//        Mutator mut_38 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class, mut_38);
//        label = Console.CONSTANTS.subsys_ejb3_timerServicePath();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class).add(
//                new PropertyBinding("path", "path", "java.lang.String", listType, this, false, false, false, "", label, true,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 20, acceptedValues));
//        mut_38.register("path", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity, Object value) {
//                entity.setPath((java.lang.String) value);
//            }
//        });
//
//        mut_38.register("path", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity) {
//                return entity.getPath();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_timerServiceRelativeTo();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class).add(
//                new PropertyBinding("relativeTo", "relative-to", "java.lang.String", listType, this, false, false, true, "",
//                        label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 25, acceptedValues));
//        mut_38.register("relativeTo", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity, Object value) {
//                entity.setRelativeTo((java.lang.String) value);
//            }
//        });
//
//        mut_38.register("relativeTo", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity) {
//                return entity.getRelativeTo();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_ejb3_threadPool();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class).add(
//                new PropertyBinding("threadPoolName", "thread-pool-name", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "COMBO_BOX", "TEXT_BOX", subgroup, tabName, 10, acceptedValues));
//        mut_38.register("threadPoolName", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity, Object value) {
//                entity.setThreadPoolName((java.lang.String) value);
//            }
//        });
//
//        mut_38.register("threadPoolName", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService entity) {
//                return entity.getThreadPoolName();
//            }
//        });
//
//        AddressBinding addr_38 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class, addr_38);
//        addr_38.add("subsystem", "ejb3");
//        addr_38.add("service", "timer-service");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService create() {
//                        return beanFactory.timerService().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.TimerService ----
//    }
//
//    public void EJB3ThreadPool_39() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_39 = new Mutator<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class, mut_39);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_39.register("name", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_39.register("name", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_39.register("maxThreads", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity, Object value) {
//                entity.setMaxThreads((java.lang.Integer) value);
//            }
//        });
//
//        mut_39.register("maxThreads", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity) {
//                return entity.getMaxThreads();
//            }
//        });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_39.register("threadFactory", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity, Object value) {
//                entity.setThreadFactory((java.lang.String) value);
//            }
//        });
//
//        mut_39.register("threadFactory", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity) {
//                return entity.getThreadFactory();
//            }
//        });
//
//        label = "Keepalive Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeout", "keepalive-time/time", "java.lang.Integer", listType, this, false,
//                        false, true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_39.register("keepaliveTimeout", new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity, Object value) {
//                entity.setKeepaliveTimeout((java.lang.Integer) value);
//            }
//        });
//
//        mut_39.register("keepaliveTimeout", new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity) {
//                return entity.getKeepaliveTimeout();
//            }
//        });
//
//        label = "Keepalive Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class)
//                .add(new PropertyBinding("keepaliveTimeoutUnit", "keepalive-time/unit", "java.lang.String", listType, this,
//                        false, false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_39.register("keepaliveTimeoutUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity, Object value) {
//                        entity.setKeepaliveTimeoutUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_39.register("keepaliveTimeoutUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool entity) {
//                        return entity.getKeepaliveTimeoutUnit();
//                    }
//                });
//
//        AddressBinding addr_39 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class, addr_39);
//        addr_39.add("subsystem", "ejb3");
//        addr_39.add("thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool create() {
//                        return beanFactory.ejb3ThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ejb3.model.EJB3ThreadPool ----
//    }
//
//    public void AsyncHandler_40() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_40 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class, mut_40);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_40.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_40.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_queueLength();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class).add(
//                new PropertyBinding("queueLength", "queue-length", "java.lang.Integer", listType, this, false, false, true,
//                        "512", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_40.register("queueLength", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity, Object value) {
//                entity.setQueueLength((java.lang.Integer) value);
//            }
//        });
//
//        mut_40.register("queueLength", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity) {
//                return entity.getQueueLength();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_subhandlers();
//        listType = java.lang.String.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class).add(
//                new PropertyBinding("handlers", "subhandlers", "java.util.List", listType, this, false, false, true, "", label,
//                        false, "STRING_LIST_EDITOR", "STRING_LIST_EDITOR", subgroup, tabName, 100, acceptedValues));
//        mut_40.register("handlers", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity, Object value) {
//                entity.setHandlers((java.util.List) value);
//            }
//        });
//
//        mut_40.register("handlers", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity) {
//                return entity.getHandlers();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_40.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_40.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_overflowAction();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "BLOCK", "DISCARD" };
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class).add(
//                new PropertyBinding("overflowAction", "overflow-action", "java.lang.String", listType, this, false, false,
//                        true, "BLOCK", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_40.register("overflowAction", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity, Object value) {
//                entity.setOverflowAction((java.lang.String) value);
//            }
//        });
//
//        mut_40.register("overflowAction", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler entity) {
//                return entity.getOverflowAction();
//            }
//        });
//
//        AddressBinding addr_40 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class, addr_40);
//        addr_40.add("subsystem", "logging");
//        addr_40.add("async-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler create() {
//                        return beanFactory.asyncHandler().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.AsyncHandler ----
//    }
//
//    public void ConsoleHandler_41() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_41 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class, mut_41);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_41.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_41.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_encoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("encoding", "encoding", "java.lang.String", listType, this, false, false, true, "UTF-8",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_41.register("encoding", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setEncoding((java.lang.String) value);
//            }
//        });
//
//        mut_41.register("encoding", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.getEncoding();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_target();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("target", "target", "java.lang.String", listType, this, false, false, true, "System.out",
//                        label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_41.register("target", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setTarget((java.lang.String) value);
//            }
//        });
//
//        mut_41.register("target", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.getTarget();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_formatter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("formatter", "formatter", "java.lang.String", listType, this, false, false, true,
//                        "%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n", label, false, "FREE_FORM_TEXT_BOX", "FREE_FORM_TEXT_BOX",
//                        subgroup, tabName, 100, acceptedValues));
//        mut_41.register("formatter", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setFormatter((java.lang.String) value);
//            }
//        });
//
//        mut_41.register("formatter", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.getFormatter();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_41.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_41.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_autoFlush();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class).add(
//                new PropertyBinding("autoFlush", "autoflush", "java.lang.Boolean", listType, this, false, false, true, "true",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_41.register("autoFlush", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity, Object value) {
//                entity.setAutoFlush((java.lang.Boolean) value);
//            }
//        });
//
//        mut_41.register("autoFlush", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler entity) {
//                return entity.isAutoFlush();
//            }
//        });
//
//        AddressBinding addr_41 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class, addr_41);
//        addr_41.add("subsystem", "logging");
//        addr_41.add("console-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler create() {
//                        return beanFactory.consoleHanlder().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.ConsoleHandler ----
//    }
//
//    public void PeriodicRotatingFileHandler_42() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_42 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class, mut_42);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("name",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setName((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("name",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getName();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_encoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("encoding", "encoding", "java.lang.String", listType, this, false, false, true, "UTF-8",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("encoding",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setEncoding((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("encoding",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getEncoding();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_suffix();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("suffix", "suffix", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("suffix",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setSuffix((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("suffix",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getSuffix();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_formatter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("formatter", "formatter", "java.lang.String", listType, this, false, false, true,
//                        "%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n", label, true, "FREE_FORM_TEXT_BOX", "FREE_FORM_TEXT_BOX",
//                        subgroup, tabName, 100, acceptedValues));
//        mut_42.register("formatter",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFormatter((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("formatter",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getFormatter();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("level",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setLevel((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("level",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getLevel();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_append();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("append", "append", "java.lang.Boolean", listType, this, false, false, true, "true", label,
//                        false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("append",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setAppend((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_42.register("append",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.isAppend();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_autoFlush();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("autoFlush", "autoflush", "java.lang.Boolean", listType, this, false, false, true, "true",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("autoFlush",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setAutoFlush((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_42.register("autoFlush",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.isAutoFlush();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_filePath();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("filePath", "file/path", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_42.register("filePath",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFilePath((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("filePath",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getFilePath();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_fileRelativeTo();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class).add(
//                new PropertyBinding("fileRelativeTo", "file/relative-to", "java.lang.String", listType, this, false, false,
//                        true, "jboss.server.log.dir", label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_42.register("fileRelativeTo",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFileRelativeTo((java.lang.String) value);
//                    }
//                });
//
//        mut_42.register("fileRelativeTo",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler entity) {
//                        return entity.getFileRelativeTo();
//                    }
//                });
//
//        AddressBinding addr_42 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class, addr_42);
//        addr_42.add("subsystem", "logging");
//        addr_42.add("periodic-rotating-file-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler create() {
//                        return beanFactory.periodicRotatingFileHandler().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.PeriodicRotatingFileHandler ----
//    }
//
//    public void SizeRotatingFileHandler_43() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_43 = new Mutator<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class, mut_43);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("name", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                    Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_43.register("name", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_encoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("encoding", "encoding", "java.lang.String", listType, this, false, false, true, "UTF-8",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("encoding",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setEncoding((java.lang.String) value);
//                    }
//                });
//
//        mut_43.register("encoding",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getEncoding();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_formatter();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("formatter", "formatter", "java.lang.String", listType, this, false, false, true,
//                        "%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n", label, true, "FREE_FORM_TEXT_BOX", "FREE_FORM_TEXT_BOX",
//                        subgroup, tabName, 100, acceptedValues));
//        mut_43.register("formatter",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFormatter((java.lang.String) value);
//                    }
//                });
//
//        mut_43.register("formatter",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getFormatter();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_logLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("level", "level", "java.lang.String", listType, this, false, false, true, "INFO", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("level", new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                    Object value) {
//                entity.setLevel((java.lang.String) value);
//            }
//        });
//
//        mut_43.register("level", new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                return entity.getLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_logging_append();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("append", "append", "java.lang.Boolean", listType, this, false, false, true, "true", label,
//                        false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("append",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setAppend((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_43.register("append",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.isAppend();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_autoFlush();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("autoFlush", "autoflush", "java.lang.Boolean", listType, this, false, false, true, "true",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("autoFlush",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setAutoFlush((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_43.register("autoFlush",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.isAutoFlush();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_filePath();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("filePath", "file/path", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("filePath",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFilePath((java.lang.String) value);
//                    }
//                });
//
//        mut_43.register("filePath",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getFilePath();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_fileRelativeTo();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("fileRelativeTo", "file/relative-to", "java.lang.String", listType, this, false, false,
//                        true, "jboss.server.log.dir", label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_43.register("fileRelativeTo",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setFileRelativeTo((java.lang.String) value);
//                    }
//                });
//
//        mut_43.register("fileRelativeTo",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getFileRelativeTo();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_maxBackupIndex();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("maxBackupIndex", "max-backup-index", "java.lang.Integer", listType, this, false, false,
//                        true, "1", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("maxBackupIndex",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setMaxBackupIndex((java.lang.Integer) value);
//                    }
//                });
//
//        mut_43.register("maxBackupIndex",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getMaxBackupIndex();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_logging_rotateSize();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class).add(
//                new PropertyBinding("rotateSize", "rotate-size", "java.lang.String", listType, this, false, false, true, "2m",
//                        label, true, "BYTE_UNIT", "BYTE_UNIT", subgroup, tabName, 100, acceptedValues));
//        mut_43.register("rotateSize",
//                new Setter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity,
//                            Object value) {
//                        entity.setRotateSize((java.lang.String) value);
//                    }
//                });
//
//        mut_43.register("rotateSize",
//                new Getter<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler entity) {
//                        return entity.getRotateSize();
//                    }
//                });
//
//        AddressBinding addr_43 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class, addr_43);
//        addr_43.add("subsystem", "logging");
//        addr_43.add("size-rotating-file-handler", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler>() {
//                    public org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler create() {
//                        return beanFactory.sizeRotatingFileHandler().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.logging.model.SizeRotatingFileHandler ----
//    }
//
//    public void DeploymentScanner_44() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_44 = new Mutator<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class, mut_44);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("name",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setName((java.lang.String) value);
//                    }
//                });
//
//        mut_44.register("name",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.getName();
//                    }
//                });
//
//        label = Console.CONSTANTS.common_label_path();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("path", "path", "java.lang.String", listType, this, false, false, true, "deployments",
//                        label, true, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("path",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setPath((java.lang.String) value);
//                    }
//                });
//
//        mut_44.register("path",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.getPath();
//                    }
//                });
//
//        label = Console.CONSTANTS.common_label_enabled();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("enabled", "scan-enabled", "java.lang.Boolean", listType, this, false, false, true,
//                        "false", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("enabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_44.register("enabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.isEnabled();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_deploymentscanner_autoDeployExploded();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("autoDeployExploded", "auto-deploy-exploded", "java.lang.Boolean", listType, this, false,
//                        false, true, "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("autoDeployExploded",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setAutoDeployExploded((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_44.register("autoDeployExploded",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.isAutoDeployExploded();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_deploymentscanner_autoDeployZipped();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("autoDeployZipped", "auto-deploy-zipped", "java.lang.Boolean", listType, this, false,
//                        false, true, "true", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("autoDeployZipped",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setAutoDeployZipped((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_44.register("autoDeployZipped",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.isAutoDeployZipped();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_deploymentscanner_scanInterval();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("scanInterval", "scan-interval", "java.lang.Integer", listType, this, false, false, true,
//                        "5000", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("scanInterval",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setScanInterval((java.lang.Integer) value);
//                    }
//                });
//
//        mut_44.register("scanInterval",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.getScanInterval();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_deploymentscanner_relativeTo();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("relativeTo", "relative-to", "java.lang.String", listType, this, false, false, true,
//                        "jboss.server.base.dir", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("relativeTo",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setRelativeTo((java.lang.String) value);
//                    }
//                });
//
//        mut_44.register("relativeTo",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.getRelativeTo();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_deploymentscanner_deploymentTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class).add(
//                new PropertyBinding("deploymentTimeout", "deployment-timeout", "java.lang.Long", listType, this, false, false,
//                        true, "60", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_44.register("deploymentTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity,
//                            Object value) {
//                        entity.setDeploymentTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_44.register("deploymentTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner entity) {
//                        return entity.getDeploymentTimeout();
//                    }
//                });
//
//        AddressBinding addr_44 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class, addr_44);
//        addr_44.add("subsystem", "deployment-scanner");
//        addr_44.add("scanner", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner>() {
//                    public org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner create() {
//                        return beanFactory.deploymentScanner().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.deploymentscanner.model.DeploymentScanner ----
//    }
//
//    public void SocketGroup_45() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.general.model.SocketGroup.class, new ArrayList<PropertyBinding>());
//        Mutator mut_45 = new Mutator<org.jboss.as.console.client.shared.general.model.SocketGroup>();
//        mutators.put(org.jboss.as.console.client.shared.general.model.SocketGroup.class, mut_45);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketGroup.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_45.register("name", new Setter<org.jboss.as.console.client.shared.general.model.SocketGroup>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketGroup entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_45.register("name", new Getter<org.jboss.as.console.client.shared.general.model.SocketGroup>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketGroup entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.SocketGroup.class).add(
//                new PropertyBinding("defaultInterface", "default-interface", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_45.register("defaultInterface", new Setter<org.jboss.as.console.client.shared.general.model.SocketGroup>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.SocketGroup entity, Object value) {
//                entity.setDefaultInterface((java.lang.String) value);
//            }
//        });
//
//        mut_45.register("defaultInterface", new Getter<org.jboss.as.console.client.shared.general.model.SocketGroup>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.SocketGroup entity) {
//                return entity.getDefaultInterface();
//            }
//        });
//
//        AddressBinding addr_45 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.general.model.SocketGroup.class, addr_45);
//        addr_45.add("socket-binding-group", "{0}");
//        factories.put(org.jboss.as.console.client.shared.general.model.SocketGroup.class,
//                new EntityFactory<org.jboss.as.console.client.shared.general.model.SocketGroup>() {
//                    public org.jboss.as.console.client.shared.general.model.SocketGroup create() {
//                        return beanFactory.socketGroup().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.general.model.SocketGroup ----
//    }
//
//    public void DeploymentReference_46() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.deployment.DeploymentReference.class, new ArrayList<PropertyBinding>());
//        Mutator mut_46 = new Mutator<org.jboss.as.console.client.shared.deployment.DeploymentReference>();
//        mutators.put(org.jboss.as.console.client.shared.deployment.DeploymentReference.class, mut_46);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.deployment.DeploymentReference.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_46.register("name", new Setter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public void invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_46.register("name", new Getter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public Object invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.deployment.DeploymentReference.class).add(
//                new PropertyBinding("hash", "hash", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_46.register("hash", new Setter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public void invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity, Object value) {
//                entity.setHash((java.lang.String) value);
//            }
//        });
//
//        mut_46.register("hash", new Getter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public Object invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity) {
//                return entity.getHash();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.deployment.DeploymentReference.class).add(
//                new PropertyBinding("group", "group", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_46.register("group", new Setter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public void invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity, Object value) {
//                entity.setGroup((java.lang.String) value);
//            }
//        });
//
//        mut_46.register("group", new Getter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public Object invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity) {
//                return entity.getGroup();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.deployment.DeploymentReference.class).add(
//                new PropertyBinding("runtimeName", "runtimeName", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_46.register("runtimeName", new Setter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public void invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity, Object value) {
//                entity.setRuntimeName((java.lang.String) value);
//            }
//        });
//
//        mut_46.register("runtimeName", new Getter<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//            public Object invoke(org.jboss.as.console.client.shared.deployment.DeploymentReference entity) {
//                return entity.getRuntimeName();
//            }
//        });
//
//        AddressBinding addr_46 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.deployment.DeploymentReference.class, addr_46);
//        factories.put(org.jboss.as.console.client.shared.deployment.DeploymentReference.class,
//                new EntityFactory<org.jboss.as.console.client.shared.deployment.DeploymentReference>() {
//                    public org.jboss.as.console.client.shared.deployment.DeploymentReference create() {
//                        return beanFactory.deploymentReference().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.deployment.DeploymentReference ----
//    }
//
//    public void MessagingProvider_47() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_47 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class, mut_47);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("name", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_47.register("name", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("messageCounterEnabled", "message-counter-enabled", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("messageCounterEnabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity,
//                            Object value) {
//                        entity.setMessageCounterEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_47.register("messageCounterEnabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                        return entity.isMessageCounterEnabled();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("persistenceEnabled", "persistence-enabled", "java.lang.Boolean", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("persistenceEnabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity,
//                            Object value) {
//                        entity.setPersistenceEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_47.register("persistenceEnabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                        return entity.isPersistenceEnabled();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("securityEnabled", "security-enabled", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("securityEnabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity,
//                            Object value) {
//                        entity.setSecurityEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_47.register("securityEnabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                        return entity.isSecurityEnabled();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("acceptorBinding", "acceptorBinding", "java.lang.String", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("acceptorBinding",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity,
//                            Object value) {
//                        entity.setAcceptorBinding((java.lang.String) value);
//                    }
//                });
//
//        mut_47.register("acceptorBinding",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                        return entity.getAcceptorBinding();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class).add(
//                new PropertyBinding("connectorBinding", "connectorBinding", "java.lang.String", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_47.register("connectorBinding",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity,
//                            Object value) {
//                        entity.setConnectorBinding((java.lang.String) value);
//                    }
//                });
//
//        mut_47.register("connectorBinding",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider entity) {
//                        return entity.getConnectorBinding();
//                    }
//                });
//
//        AddressBinding addr_47 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class, addr_47);
//        addr_47.add("subsystem", "messaging");
//        addr_47.add("hornetq-server", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider create() {
//                        return beanFactory.messagingProvider().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.MessagingProvider ----
//    }
//
//    public void SecurityPattern_48() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_48 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class, mut_48);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("consume", "consume", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("consume", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity, Object value) {
//                entity.setConsume((java.lang.Boolean) value);
//            }
//        });
//
//        mut_48.register("consume", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                return entity.isConsume();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("createDurableQueue", "create-durable-queue", "java.lang.Boolean", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("createDurableQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity,
//                            Object value) {
//                        entity.setCreateDurableQueue((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_48.register("createDurableQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                        return entity.isCreateDurableQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("createNonDurableQueue", "create-non-durable-queue", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("createNonDurableQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity,
//                            Object value) {
//                        entity.setCreateNonDurableQueue((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_48.register("createNonDurableQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                        return entity.isCreateNonDurableQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("deleteDurableQueue", "delete-durable-queue", "java.lang.Boolean", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("deleteDurableQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity,
//                            Object value) {
//                        entity.setDeleteDurableQueue((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_48.register("deleteDurableQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                        return entity.isDeleteDurableQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("deleteNonDurableQueue", "delete-non-durable-queue", "java.lang.Boolean", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("deleteNonDurableQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity,
//                            Object value) {
//                        entity.setDeleteNonDurableQueue((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_48.register("deleteNonDurableQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                        return entity.isDeleteNonDurableQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("manage", "manage", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("manage", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity, Object value) {
//                entity.setManage((java.lang.Boolean) value);
//            }
//        });
//
//        mut_48.register("manage", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                return entity.isManage();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class).add(
//                new PropertyBinding("send", "send", "java.lang.Boolean", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_48.register("send", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity, Object value) {
//                entity.setSend((java.lang.Boolean) value);
//            }
//        });
//
//        mut_48.register("send", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern entity) {
//                return entity.isSend();
//            }
//        });
//
//        AddressBinding addr_48 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class, addr_48);
//        addr_48.add("subsystem", "messaging");
//        addr_48.add("hornetq-server", "{0}");
//        addr_48.add("security-setting", "{1}");
//        addr_48.add("role", "{2}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern create() {
//                        return beanFactory.messagingSecurity().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.SecurityPattern ----
//    }
//
//    public void AddressingPattern_49() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_49 = new Mutator<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class, mut_49);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class).add(
//                new PropertyBinding("pattern", "pattern", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_49.register("pattern", new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity, Object value) {
//                entity.setPattern((java.lang.String) value);
//            }
//        });
//
//        mut_49.register("pattern", new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity) {
//                return entity.getPattern();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class).add(
//                new PropertyBinding("deadLetterQueue", "dead-letter-address", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_49.register("deadLetterQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity,
//                            Object value) {
//                        entity.setDeadLetterQueue((java.lang.String) value);
//                    }
//                });
//
//        mut_49.register("deadLetterQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity) {
//                        return entity.getDeadLetterQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class).add(
//                new PropertyBinding("expiryQueue", "expiry-address", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_49.register("expiryQueue",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity,
//                            Object value) {
//                        entity.setExpiryQueue((java.lang.String) value);
//                    }
//                });
//
//        mut_49.register("expiryQueue",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity) {
//                        return entity.getExpiryQueue();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class).add(
//                new PropertyBinding("maxDelivery", "max-delivery-attempts", "java.lang.Integer", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_49.register("maxDelivery",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity,
//                            Object value) {
//                        entity.setMaxDelivery((java.lang.Integer) value);
//                    }
//                });
//
//        mut_49.register("maxDelivery",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity) {
//                        return entity.getMaxDelivery();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class).add(
//                new PropertyBinding("redeliveryDelay", "redelivery-delay", "java.lang.Integer", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_49.register("redeliveryDelay",
//                new Setter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity,
//                            Object value) {
//                        entity.setRedeliveryDelay((java.lang.Integer) value);
//                    }
//                });
//
//        mut_49.register("redeliveryDelay",
//                new Getter<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern entity) {
//                        return entity.getRedeliveryDelay();
//                    }
//                });
//
//        AddressBinding addr_49 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class, addr_49);
//        addr_49.add("subsystem", "messaging");
//        addr_49.add("hornetq-server", "{0}");
//        addr_49.add("address-setting", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern>() {
//                    public org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern create() {
//                        return beanFactory.messagingAddress().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.messaging.model.AddressingPattern ----
//    }
//
//    public void HttpConnector_50() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class, new ArrayList<PropertyBinding>());
//        Mutator mut_50 = new Mutator<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class, mut_50);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_50.register("name", new Setter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_50.register("name", new Getter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class).add(
//                new PropertyBinding("scheme", "scheme", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_50.register("scheme", new Setter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity, Object value) {
//                entity.setScheme((java.lang.String) value);
//            }
//        });
//
//        mut_50.register("scheme", new Getter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity) {
//                return entity.getScheme();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class).add(
//                new PropertyBinding("protocol", "protocol", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_50.register("protocol", new Setter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity, Object value) {
//                entity.setProtocol((java.lang.String) value);
//            }
//        });
//
//        mut_50.register("protocol", new Getter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity) {
//                return entity.getProtocol();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_50.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_50.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class).add(
//                new PropertyBinding("socketBinding", "socket-binding", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_50.register("socketBinding", new Setter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity, Object value) {
//                entity.setSocketBinding((java.lang.String) value);
//            }
//        });
//
//        mut_50.register("socketBinding", new Getter<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector entity) {
//                return entity.getSocketBinding();
//            }
//        });
//
//        AddressBinding addr_50 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class, addr_50);
//        factories.put(org.jboss.as.console.client.shared.subsys.web.model.HttpConnector.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.web.model.HttpConnector>() {
//                    public org.jboss.as.console.client.shared.subsys.web.model.HttpConnector create() {
//                        return beanFactory.httpConnector().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.web.model.HttpConnector ----
//    }
//
//    public void VirtualServer_51() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer.class, new ArrayList<PropertyBinding>());
//        Mutator mut_51 = new Mutator<org.jboss.as.console.client.shared.subsys.web.model.VirtualServer>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer.class, mut_51);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer.class).add(
//                new PropertyBinding("defaultWebModule", "default-web-module", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_51.register("defaultWebModule", new Setter<org.jboss.as.console.client.shared.subsys.web.model.VirtualServer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer entity, Object value) {
//                entity.setDefaultWebModule((java.lang.String) value);
//            }
//        });
//
//        mut_51.register("defaultWebModule", new Getter<org.jboss.as.console.client.shared.subsys.web.model.VirtualServer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer entity) {
//                return entity.getDefaultWebModule();
//            }
//        });
//
//        AddressBinding addr_51 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer.class, addr_51);
//        addr_51.add("subsystem", "web");
//        addr_51.add("virtual-server", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.web.model.VirtualServer.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.web.model.VirtualServer>() {
//                    public org.jboss.as.console.client.shared.subsys.web.model.VirtualServer create() {
//                        return beanFactory.virtualServer().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.web.model.VirtualServer ----
//    }
//
//    public void Interface_52() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.general.model.Interface.class, new ArrayList<PropertyBinding>());
//        Mutator mut_52 = new Mutator<org.jboss.as.console.client.shared.general.model.Interface>();
//        mutators.put(org.jboss.as.console.client.shared.general.model.Interface.class, mut_52);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("name", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("name", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("inetAddress", "inet-address", "java.lang.String", listType, this, false, true, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("inetAddress", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setInetAddress((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("inetAddress", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getInetAddress();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("loopback", "loopback", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("loopback", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setLoopback((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("loopback", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isLoopback();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("anyAddress", "any-address", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("anyAddress", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setAnyAddress((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("anyAddress", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isAnyAddress();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("anyIP4Address", "any-ipv4-address", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("anyIP4Address", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setAnyIP4Address((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("anyIP4Address", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isAnyIP4Address();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("anyIP6Address", "any-ipv6-address", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("anyIP6Address", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setAnyIP6Address((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("anyIP6Address", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isAnyIP6Address();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("linkLocal", "link-local-address", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("linkLocal", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setLinkLocal((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("linkLocal", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isLinkLocal();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("multicast", "multicast", "java.lang.Boolean", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("multicast", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setMulticast((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("multicast", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isMulticast();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("pointToPoint", "point-to-point", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("pointToPoint", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setPointToPoint((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("pointToPoint", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isPointToPoint();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("publicAddress", "public-address", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("publicAddress", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setPublicAddress((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("publicAddress", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isPublicAddress();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("siteLocal", "site-local-address", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("siteLocal", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setSiteLocal((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("siteLocal", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isSiteLocal();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("up", "up", "java.lang.Boolean", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("up", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setUp((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("up", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isUp();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("virtual", "virtual", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("virtual", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setVirtual((java.lang.Boolean) value);
//            }
//        });
//
//        mut_52.register("virtual", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.isVirtual();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("loopbackAddress", "loopback-address", "java.lang.String", listType, this, false, true,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("loopbackAddress", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setLoopbackAddress((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("loopbackAddress", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getLoopbackAddress();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("nic", "nic", "java.lang.String", listType, this, false, true, true, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("nic", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setNic((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("nic", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getNic();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("nicMatch", "nic-match", "java.lang.String", listType, this, false, true, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("nicMatch", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setNicMatch((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("nicMatch", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getNicMatch();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.general.model.Interface.class).add(
//                new PropertyBinding("subnetMatch", "subnet-match", "java.lang.String", listType, this, false, true, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_52.register("subnetMatch", new Setter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public void invoke(org.jboss.as.console.client.shared.general.model.Interface entity, Object value) {
//                entity.setSubnetMatch((java.lang.String) value);
//            }
//        });
//
//        mut_52.register("subnetMatch", new Getter<org.jboss.as.console.client.shared.general.model.Interface>() {
//            public Object invoke(org.jboss.as.console.client.shared.general.model.Interface entity) {
//                return entity.getSubnetMatch();
//            }
//        });
//
//        AddressBinding addr_52 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.general.model.Interface.class, addr_52);
//        addr_52.add("interface", "{0}");
//        factories.put(org.jboss.as.console.client.shared.general.model.Interface.class,
//                new EntityFactory<org.jboss.as.console.client.shared.general.model.Interface>() {
//                    public org.jboss.as.console.client.shared.general.model.Interface create() {
//                        return beanFactory.interfaceDeclaration().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.general.model.Interface ----
//    }
//
//    public void JDBCDriver_53() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class, new ArrayList<PropertyBinding>());
//        Mutator mut_53 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class, mut_53);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("name", "driver-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_53.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("majorVersion", "major-version", "java.lang.Integer", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("majorVersion", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setMajorVersion((java.lang.Integer) value);
//            }
//        });
//
//        mut_53.register("majorVersion", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getMajorVersion();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("minorVersion", "minor-version", "java.lang.Integer", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("minorVersion", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setMinorVersion((java.lang.Integer) value);
//            }
//        });
//
//        mut_53.register("minorVersion", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getMinorVersion();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("deploymentName", "deployment-name", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("deploymentName", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setDeploymentName((java.lang.String) value);
//            }
//        });
//
//        mut_53.register("deploymentName", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getDeploymentName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("driverClass", "driver-class", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("driverClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setDriverClass((java.lang.String) value);
//            }
//        });
//
//        mut_53.register("driverClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getDriverClass();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class).add(
//                new PropertyBinding("xaDataSourceClass", "driver-xa-datasource-class-name", "java.lang.String", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_53.register("xaDataSourceClass", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity, Object value) {
//                entity.setXaDataSourceClass((java.lang.String) value);
//            }
//        });
//
//        mut_53.register("xaDataSourceClass", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver entity) {
//                return entity.getXaDataSourceClass();
//            }
//        });
//
//        AddressBinding addr_53 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class, addr_53);
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver create() {
//                        return beanFactory.jdbcDriver().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.JDBCDriver ----
//    }
//
//    public void StandaloneServer_54() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.standalone.StandaloneServer.class, new ArrayList<PropertyBinding>());
//        Mutator mut_54 = new Mutator<org.jboss.as.console.client.standalone.StandaloneServer>();
//        mutators.put(org.jboss.as.console.client.standalone.StandaloneServer.class, mut_54);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("name", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_54.register("name", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("extensions", "extensions", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("extensions", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setExtensions((java.util.List) value);
//            }
//        });
//
//        mut_54.register("extensions", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getExtensions();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("socketBinding", "socketBinding", "java.lang.String", listType, this, false, false, false,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("socketBinding", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setSocketBinding((java.lang.String) value);
//            }
//        });
//
//        mut_54.register("socketBinding", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getSocketBinding();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("releaseCodename", "releaseCodename", "java.lang.String", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("releaseCodename", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setReleaseCodename((java.lang.String) value);
//            }
//        });
//
//        mut_54.register("releaseCodename", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getReleaseCodename();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("releaseVersion", "releaseVersion", "java.lang.String", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("releaseVersion", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setReleaseVersion((java.lang.String) value);
//            }
//        });
//
//        mut_54.register("releaseVersion", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getReleaseVersion();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.standalone.StandaloneServer.class).add(
//                new PropertyBinding("serverState", "serverState", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_54.register("serverState", new Setter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public void invoke(org.jboss.as.console.client.standalone.StandaloneServer entity, Object value) {
//                entity.setServerState((java.lang.String) value);
//            }
//        });
//
//        mut_54.register("serverState", new Getter<org.jboss.as.console.client.standalone.StandaloneServer>() {
//            public Object invoke(org.jboss.as.console.client.standalone.StandaloneServer entity) {
//                return entity.getServerState();
//            }
//        });
//
//        AddressBinding addr_54 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.standalone.StandaloneServer.class, addr_54);
//        factories.put(org.jboss.as.console.client.standalone.StandaloneServer.class,
//                new EntityFactory<org.jboss.as.console.client.standalone.StandaloneServer>() {
//                    public org.jboss.as.console.client.standalone.StandaloneServer create() {
//                        return beanFactory.standaloneServer().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.standalone.StandaloneServer ----
//    }
//
//    public void WebServiceProvider_55() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_55 = new Mutator<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class, mut_55);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class).add(
//                new PropertyBinding("modifyAddress", "modify-wsdl-address", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_55.register("modifyAddress", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity, Object value) {
//                entity.setModifyAddress((java.lang.Boolean) value);
//            }
//        });
//
//        mut_55.register("modifyAddress", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity) {
//                return entity.isModifyAddress();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class).add(
//                new PropertyBinding("wsdlPort", "wsdl-port", "java.lang.Integer", listType, this, false, true, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_55.register("wsdlPort", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity, Object value) {
//                entity.setWsdlPort((java.lang.Integer) value);
//            }
//        });
//
//        mut_55.register("wsdlPort", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity) {
//                return entity.getWsdlPort();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class).add(
//                new PropertyBinding("wsdlSecurePort", "wsdl-secure-port", "java.lang.Integer", listType, this, false, true,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_55.register("wsdlSecurePort", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity, Object value) {
//                entity.setWsdlSecurePort((java.lang.Integer) value);
//            }
//        });
//
//        mut_55.register("wsdlSecurePort", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity) {
//                return entity.getWsdlSecurePort();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class).add(
//                new PropertyBinding("wsdlHost", "wsdl-host", "java.lang.String", listType, this, false, true, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_55.register("wsdlHost", new Setter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity, Object value) {
//                entity.setWsdlHost((java.lang.String) value);
//            }
//        });
//
//        mut_55.register("wsdlHost", new Getter<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider entity) {
//                return entity.getWsdlHost();
//            }
//        });
//
//        AddressBinding addr_55 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class, addr_55);
//        addr_55.add("subsystem", "webservices");
//        factories.put(org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider>() {
//                    public org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider create() {
//                        return beanFactory.WebServiceProvider().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.ws.model.WebServiceProvider ----
//    }
//
//    public void ConfigAdminData_56() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_56 = new Mutator<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class, mut_56);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_56.register("properties",
//                new Setter<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData entity,
//                            Object value) {
//                        entity.setProperties((java.util.List) value);
//                    }
//                });
//
//        mut_56.register("properties",
//                new Getter<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData entity) {
//                        return entity.getProperties();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class).add(
//                new PropertyBinding("pid", "pid", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_56.register("pid", new Setter<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData entity, Object value) {
//                entity.setPid((java.lang.String) value);
//            }
//        });
//
//        mut_56.register("pid", new Getter<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData entity) {
//                return entity.getPid();
//            }
//        });
//
//        AddressBinding addr_56 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class, addr_56);
//        factories.put(org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData>() {
//                    public org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData create() {
//                        return beanFactory.configAdminData().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.configadmin.model.ConfigAdminData ----
//    }
//
//    public void OSGiSubsystem_57() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_57 = new Mutator<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem.class, mut_57);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem.class).add(
//                new PropertyBinding("lazyActivation", "lazyActivation", "java.lang.Boolean", listType, this, false, false,
//                        false, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_57.register("lazyActivation",
//                new Setter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem entity,
//                            Object value) {
//                        entity.setLazyActivation((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_57.register("lazyActivation",
//                new Getter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem entity) {
//                        return entity.isLazyActivation();
//                    }
//                });
//
//        AddressBinding addr_57 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem.class, addr_57);
//        factories.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem create() {
//                        return beanFactory.osgiSubsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiSubsystem ----
//    }
//
//    public void OSGiCapability_58() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_58 = new Mutator<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class, mut_58);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class).add(
//                new PropertyBinding("identifier", "identifier", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_58.register("identifier", new Setter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability entity, Object value) {
//                entity.setIdentifier((java.lang.String) value);
//            }
//        });
//
//        mut_58.register("identifier", new Getter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability entity) {
//                return entity.getIdentifier();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class).add(
//                new PropertyBinding("startLevel", "startlevel", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_58.register("startLevel", new Setter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability entity, Object value) {
//                entity.setStartLevel((java.lang.String) value);
//            }
//        });
//
//        mut_58.register("startLevel", new Getter<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability entity) {
//                return entity.getStartLevel();
//            }
//        });
//
//        AddressBinding addr_58 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class, addr_58);
//        factories.put(org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability>() {
//                    public org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability create() {
//                        return beanFactory.osgiCapability().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.osgi.config.model.OSGiCapability ----
//    }
//
//    public void OSGiFramework_59() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_59 = new Mutator<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework.class, mut_59);
//        label = Console.CONSTANTS.subsys_osgi_capabilityStartLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework.class).add(
//                new PropertyBinding("startLevel", "startlevel", "java.lang.Integer", listType, this, false, false, true, "1",
//                        label, false, "NUMBER_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_59.register("startLevel", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework entity, Object value) {
//                entity.setStartLevel((java.lang.Integer) value);
//            }
//        });
//
//        mut_59.register("startLevel", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework entity) {
//                return entity.getStartLevel();
//            }
//        });
//
//        AddressBinding addr_59 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework.class, addr_59);
//        addr_59.add("subsystem", "osgi");
//        factories.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework>() {
//                    public org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework create() {
//                        return beanFactory.osgiFramework().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiFramework ----
//    }
//
//    public void OSGiBundle_60() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_60 = new Mutator<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class, mut_60);
//        label = Console.CONSTANTS.subsys_osgi_bundleID();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("name", "id", "java.lang.String", listType, this, true, false, true, "", label, false,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 1, acceptedValues));
//        mut_60.register("name", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_60.register("name", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_osgi_bundleState();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("state", "state", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 6, acceptedValues));
//        mut_60.register("state", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setState((java.lang.String) value);
//            }
//        });
//
//        mut_60.register("state", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getState();
//            }
//        });
//
//        label = Console.CONSTANTS.common_label_type();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("type", "type", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 4, acceptedValues));
//        mut_60.register("type", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setType((java.lang.String) value);
//            }
//        });
//
//        mut_60.register("type", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getType();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_osgi_bundleVersion();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("version", "version", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 3, acceptedValues));
//        mut_60.register("version", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setVersion((java.lang.String) value);
//            }
//        });
//
//        mut_60.register("version", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getVersion();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_osgi_capabilityStartLevel();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("startLevel", "startlevel", "java.lang.Integer", listType, this, false, false, true, "",
//                        label, false, "NUMBER_BOX", "TEXT_BOX", subgroup, tabName, 5, acceptedValues));
//        mut_60.register("startLevel", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setStartLevel((java.lang.Integer) value);
//            }
//        });
//
//        mut_60.register("startLevel", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getStartLevel();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_osgi_bundleSymbolicName();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class).add(
//                new PropertyBinding("symbolicName", "symbolic-name", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 2, acceptedValues));
//        mut_60.register("symbolicName", new Setter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity, Object value) {
//                entity.setSymbolicName((java.lang.String) value);
//            }
//        });
//
//        mut_60.register("symbolicName", new Getter<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle entity) {
//                return entity.getSymbolicName();
//            }
//        });
//
//        AddressBinding addr_60 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class, addr_60);
//        addr_60.add("subsystem", "osgi");
//        addr_60.add("bundle", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle>() {
//                    public org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle create() {
//                        return beanFactory.osgiBundle().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.osgi.runtime.model.OSGiBundle ----
//    }
//
//    public void HeapMetric_61() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class, new ArrayList<PropertyBinding>());
//        Mutator mut_61 = new Mutator<org.jboss.as.console.client.shared.jvm.model.HeapMetric>();
//        mutators.put(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class, mut_61);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class).add(
//                new PropertyBinding("max", "max", "java.lang.Long", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_61.register("max", new Setter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity, Object value) {
//                entity.setMax((java.lang.Long) value);
//            }
//        });
//
//        mut_61.register("max", new Getter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity) {
//                return entity.getMax();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class).add(
//                new PropertyBinding("committed", "committed", "java.lang.Long", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_61.register("committed", new Setter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity, Object value) {
//                entity.setCommitted((java.lang.Long) value);
//            }
//        });
//
//        mut_61.register("committed", new Getter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity) {
//                return entity.getCommitted();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class).add(
//                new PropertyBinding("init", "init", "java.lang.Long", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_61.register("init", new Setter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity, Object value) {
//                entity.setInit((java.lang.Long) value);
//            }
//        });
//
//        mut_61.register("init", new Getter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity) {
//                return entity.getInit();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class).add(
//                new PropertyBinding("used", "used", "java.lang.Long", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_61.register("used", new Setter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity, Object value) {
//                entity.setUsed((java.lang.Long) value);
//            }
//        });
//
//        mut_61.register("used", new Getter<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.HeapMetric entity) {
//                return entity.getUsed();
//            }
//        });
//
//        AddressBinding addr_61 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class, addr_61);
//        factories.put(org.jboss.as.console.client.shared.jvm.model.HeapMetric.class,
//                new EntityFactory<org.jboss.as.console.client.shared.jvm.model.HeapMetric>() {
//                    public org.jboss.as.console.client.shared.jvm.model.HeapMetric create() {
//                        return beanFactory.heapMetric().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.jvm.model.HeapMetric ----
//    }
//
//    public void ThreadMetric_62() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class, new ArrayList<PropertyBinding>());
//        Mutator mut_62 = new Mutator<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>();
//        mutators.put(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class, mut_62);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class).add(
//                new PropertyBinding("count", "thread-count", "java.lang.Long", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_62.register("count", new Setter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity, Object value) {
//                entity.setCount((java.lang.Long) value);
//            }
//        });
//
//        mut_62.register("count", new Getter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity) {
//                return entity.getCount();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class).add(
//                new PropertyBinding("daemonCount", "daemon-thread-count", "java.lang.Long", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_62.register("daemonCount", new Setter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity, Object value) {
//                entity.setDaemonCount((java.lang.Long) value);
//            }
//        });
//
//        mut_62.register("daemonCount", new Getter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity) {
//                return entity.getDaemonCount();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class).add(
//                new PropertyBinding("peakCount", "peak-thread-count", "java.lang.Long", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_62.register("peakCount", new Setter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity, Object value) {
//                entity.setPeakCount((java.lang.Long) value);
//            }
//        });
//
//        mut_62.register("peakCount", new Getter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity) {
//                return entity.getPeakCount();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class).add(
//                new PropertyBinding("totalStarted", "total-started-thread-count", "java.lang.Long", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_62.register("totalStarted", new Setter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity, Object value) {
//                entity.setTotalStarted((java.lang.Long) value);
//            }
//        });
//
//        mut_62.register("totalStarted", new Getter<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.ThreadMetric entity) {
//                return entity.getTotalStarted();
//            }
//        });
//
//        AddressBinding addr_62 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class, addr_62);
//        factories.put(org.jboss.as.console.client.shared.jvm.model.ThreadMetric.class,
//                new EntityFactory<org.jboss.as.console.client.shared.jvm.model.ThreadMetric>() {
//                    public org.jboss.as.console.client.shared.jvm.model.ThreadMetric create() {
//                        return beanFactory.threadMetric().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.jvm.model.ThreadMetric ----
//    }
//
//    public void OSMetric_63() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.jvm.model.OSMetric.class, new ArrayList<PropertyBinding>());
//        Mutator mut_63 = new Mutator<org.jboss.as.console.client.shared.jvm.model.OSMetric>();
//        mutators.put(org.jboss.as.console.client.shared.jvm.model.OSMetric.class, mut_63);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.OSMetric.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_63.register("name", new Setter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_63.register("name", new Getter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.OSMetric.class).add(
//                new PropertyBinding("version", "version", "java.lang.String", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_63.register("version", new Setter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity, Object value) {
//                entity.setVersion((java.lang.String) value);
//            }
//        });
//
//        mut_63.register("version", new Getter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity) {
//                return entity.getVersion();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.jvm.model.OSMetric.class).add(
//                new PropertyBinding("numProcessors", "available-processors", "java.lang.Integer", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_63.register("numProcessors", new Setter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public void invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity, Object value) {
//                entity.setNumProcessors((java.lang.Integer) value);
//            }
//        });
//
//        mut_63.register("numProcessors", new Getter<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//            public Object invoke(org.jboss.as.console.client.shared.jvm.model.OSMetric entity) {
//                return entity.getNumProcessors();
//            }
//        });
//
//        AddressBinding addr_63 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.jvm.model.OSMetric.class, addr_63);
//        factories.put(org.jboss.as.console.client.shared.jvm.model.OSMetric.class,
//                new EntityFactory<org.jboss.as.console.client.shared.jvm.model.OSMetric>() {
//                    public org.jboss.as.console.client.shared.jvm.model.OSMetric create() {
//                        return beanFactory.osmetric().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.jvm.model.OSMetric ----
//    }
//
//    public void DefaultCacheContainer_64() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_64 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer.class, mut_64);
//        label = "Default Cache Container";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer.class).add(
//                new PropertyBinding("name", "default-cache-container", "java.lang.String", listType, this, false, false, true,
//                        "", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_64.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer entity,
//                    Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_64.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer entity) {
//                return entity.getName();
//            }
//        });
//
//        AddressBinding addr_64 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer.class, addr_64);
//        addr_64.add("subsystem", "infinispan");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer create() {
//                        return beanFactory.defaultCacheContainer().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.DefaultCacheContainer ----
//    }
//
//    public void LocalCache_65() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_65 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class, mut_65);
//        label = "Name";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("name", "local-cache", "java.lang.String", listType, this, false, false, true, "", label,
//                        true, "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_65.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Concurrency Level";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("concurrencyLevel", "locking/concurrency-level", "java.lang.Integer", listType, this,
//                        false, false, true, "1000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_65.register("concurrencyLevel",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity,
//                            Object value) {
//                        entity.setConcurrencyLevel((java.lang.Integer) value);
//                    }
//                });
//
//        mut_65.register("concurrencyLevel",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                        return entity.getConcurrencyLevel();
//                    }
//                });
//
//        label = "Default for cache container?";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("default", "default-for-cache-container", "java.lang.Boolean", listType, this, false,
//                        false, true, "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("default", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setDefault((java.lang.Boolean) value);
//            }
//        });
//
//        mut_65.register("default", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.isDefault();
//            }
//        });
//
//        label = "Batching";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("batching", "batching", "java.lang.Boolean", listType, this, false, false, true, "false",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("batching", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setBatching((java.lang.Boolean) value);
//            }
//        });
//
//        mut_65.register("batching", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.isBatching();
//            }
//        });
//
//        label = "Striping";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("striping", "locking/striping", "java.lang.Boolean", listType, this, false, false, true,
//                        "false", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("striping", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setStriping((java.lang.Boolean) value);
//            }
//        });
//
//        mut_65.register("striping", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.isStriping();
//            }
//        });
//
//        label = "Max Entries";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("maxEntries", "eviction/max-entries", "java.lang.Integer", listType, this, false, false,
//                        true, "10000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("maxEntries", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setMaxEntries((java.lang.Integer) value);
//            }
//        });
//
//        mut_65.register("maxEntries", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getMaxEntries();
//            }
//        });
//
//        label = "Acquire Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("acquireTimeout", "locking/acquire-timeout", "java.lang.Long", listType, this, false,
//                        false, true, "15000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("acquireTimeout", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setAcquireTimeout((java.lang.Long) value);
//            }
//        });
//
//        mut_65.register("acquireTimeout", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getAcquireTimeout();
//            }
//        });
//
//        label = "Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("interval", "expiration/interval", "java.lang.Long", listType, this, false, false, true,
//                        "5000", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_65.register("interval", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setInterval((java.lang.Long) value);
//            }
//        });
//
//        mut_65.register("interval", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getInterval();
//            }
//        });
//
//        label = "Lifespan";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("lifespan", "expiration/lifespan", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_65.register("lifespan", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setLifespan((java.lang.Long) value);
//            }
//        });
//
//        mut_65.register("lifespan", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getLifespan();
//            }
//        });
//
//        label = "Max Idle";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("maxIdle", "expiration/max-idle", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_65.register("maxIdle", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setMaxIdle((java.lang.Long) value);
//            }
//        });
//
//        mut_65.register("maxIdle", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getMaxIdle();
//            }
//        });
//
//        label = "Cache Container";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("cacheContainer", "cache-container", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "TEXT", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("cacheContainer", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setCacheContainer((java.lang.String) value);
//            }
//        });
//
//        mut_65.register("cacheContainer", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getCacheContainer();
//            }
//        });
//
//        label = "Controller Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "EAGER", "LAZY" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("controllerMode", "controller-mode", "java.lang.String", listType, this, false, false,
//                        true, "LAZY", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("controllerMode", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setControllerMode((java.lang.String) value);
//            }
//        });
//
//        mut_65.register("controllerMode", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getControllerMode();
//            }
//        });
//
//        label = "Eviction Strategy";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] { "NONE", "UNORDERED", "FIFO", "LRU", "LIRS" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("evictionStrategy", "eviction/strategy", "java.lang.String", listType, this, false, false,
//                        true, "NONE", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("evictionStrategy",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity,
//                            Object value) {
//                        entity.setEvictionStrategy((java.lang.String) value);
//                    }
//                });
//
//        mut_65.register("evictionStrategy",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                        return entity.getEvictionStrategy();
//                    }
//                });
//
//        label = "Indexing";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "NONE", "LOCAL", "ALL" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("indexing", "indexing", "java.lang.String", listType, this, false, false, true, "NONE",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("indexing", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setIndexing((java.lang.String) value);
//            }
//        });
//
//        mut_65.register("indexing", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getIndexing();
//            }
//        });
//
//        label = "Isolation";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] { "NONE", "READ_UNCOMMITTED", "READ_COMMITTED", "REPEATABLE_READ", "SERIALIZABLE" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class).add(
//                new PropertyBinding("isolation", "locking/isolation", "java.lang.String", listType, this, false, false, true,
//                        "REPEATABLE_READ", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_65.register("isolation", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity, Object value) {
//                entity.setIsolation((java.lang.String) value);
//            }
//        });
//
//        mut_65.register("isolation", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache entity) {
//                return entity.getIsolation();
//            }
//        });
//
//        AddressBinding addr_65 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class, addr_65);
//        addr_65.add("subsystem", "infinispan");
//        addr_65.add("cache-container", "{0}");
//        addr_65.add("local-cache", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache create() {
//                        return beanFactory.localCache().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.LocalCache ----
//    }
//
//    public void InvalidationCache_66() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_66 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class, mut_66);
//        label = "Name";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("name", "invalidation-cache", "java.lang.String", listType, this, false, false, true, "",
//                        label, true, "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_66.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Concurrency Level";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("concurrencyLevel", "locking/concurrency-level", "java.lang.Integer", listType, this,
//                        false, false, true, "1000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_66.register("concurrencyLevel",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setConcurrencyLevel((java.lang.Integer) value);
//                    }
//                });
//
//        mut_66.register("concurrencyLevel",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getConcurrencyLevel();
//                    }
//                });
//
//        label = "Default for cache container?";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("default", "default-for-cache-container", "java.lang.Boolean", listType, this, false,
//                        false, true, "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("default", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setDefault((java.lang.Boolean) value);
//            }
//        });
//
//        mut_66.register("default", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.isDefault();
//            }
//        });
//
//        label = "Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] { "ASYNC", "SYNC" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("mode", "mode", "java.lang.String", listType, this, false, false, true, "ASYNC", label,
//                        true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("mode", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setMode((java.lang.String) value);
//            }
//        });
//
//        mut_66.register("mode", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getMode();
//            }
//        });
//
//        label = "Queue Size";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("queueSize", "queue-size", "java.lang.Integer", listType, this, false, false, true, "1000",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("queueSize",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setQueueSize((java.lang.Integer) value);
//                    }
//                });
//
//        mut_66.register("queueSize",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getQueueSize();
//                    }
//                });
//
//        label = "Batching";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("batching", "batching", "java.lang.Boolean", listType, this, false, false, true, "false",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("batching", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setBatching((java.lang.Boolean) value);
//            }
//        });
//
//        mut_66.register("batching", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.isBatching();
//            }
//        });
//
//        label = "Striping";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("striping", "locking/striping", "java.lang.Boolean", listType, this, false, false, true,
//                        "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("striping", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setStriping((java.lang.Boolean) value);
//            }
//        });
//
//        mut_66.register("striping", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.isStriping();
//            }
//        });
//
//        label = "Max Entries";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("maxEntries", "eviction/max-entries", "java.lang.Integer", listType, this, false, false,
//                        true, "10000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("maxEntries",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setMaxEntries((java.lang.Integer) value);
//                    }
//                });
//
//        mut_66.register("maxEntries",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getMaxEntries();
//                    }
//                });
//
//        label = "Acquire Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("acquireTimeout", "locking/acquire-timeout", "java.lang.Long", listType, this, false,
//                        false, true, "15000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("acquireTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setAcquireTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_66.register("acquireTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getAcquireTimeout();
//                    }
//                });
//
//        label = "Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("interval", "expiration/interval", "java.lang.Long", listType, this, false, false, true,
//                        "5000", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_66.register("interval", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setInterval((java.lang.Long) value);
//            }
//        });
//
//        mut_66.register("interval", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getInterval();
//            }
//        });
//
//        label = "Lifespan";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("lifespan", "expiration/lifespan", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_66.register("lifespan", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setLifespan((java.lang.Long) value);
//            }
//        });
//
//        mut_66.register("lifespan", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getLifespan();
//            }
//        });
//
//        label = "Max Idle";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("maxIdle", "expiration/max-idle", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_66.register("maxIdle", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setMaxIdle((java.lang.Long) value);
//            }
//        });
//
//        mut_66.register("maxIdle", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getMaxIdle();
//            }
//        });
//
//        label = "Queue Flush Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("queueFlushInterval", "queue-flush-interval", "java.lang.Long", listType, this, false,
//                        false, true, "10", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("queueFlushInterval",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setQueueFlushInterval((java.lang.Long) value);
//                    }
//                });
//
//        mut_66.register("queueFlushInterval",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getQueueFlushInterval();
//                    }
//                });
//
//        label = "Remote Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("remoteTimeout", "remote-timeout", "java.lang.Long", listType, this, false, false, true,
//                        "17500", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("remoteTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setRemoteTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_66.register("remoteTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getRemoteTimeout();
//                    }
//                });
//
//        label = "Cache Container";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("cacheContainer", "cache-container", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "TEXT", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("cacheContainer",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setCacheContainer((java.lang.String) value);
//                    }
//                });
//
//        mut_66.register("cacheContainer",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getCacheContainer();
//                    }
//                });
//
//        label = "Controller Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "EAGER", "LAZY" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("controllerMode", "controller-mode", "java.lang.String", listType, this, false, false,
//                        true, "LAZY", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("controllerMode",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setControllerMode((java.lang.String) value);
//                    }
//                });
//
//        mut_66.register("controllerMode",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getControllerMode();
//                    }
//                });
//
//        label = "Eviction Strategy";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] { "NONE", "UNORDERED", "FIFO", "LRU", "LIRS" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("evictionStrategy", "eviction/strategy", "java.lang.String", listType, this, false, false,
//                        true, "NONE", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("evictionStrategy",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setEvictionStrategy((java.lang.String) value);
//                    }
//                });
//
//        mut_66.register("evictionStrategy",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getEvictionStrategy();
//                    }
//                });
//
//        label = "Indexing";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "NONE", "LOCAL", "ALL" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("indexing", "indexing", "java.lang.String", listType, this, false, false, true, "NONE",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("indexing", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity, Object value) {
//                entity.setIndexing((java.lang.String) value);
//            }
//        });
//
//        mut_66.register("indexing", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                return entity.getIndexing();
//            }
//        });
//
//        label = "Isolation";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] { "NONE", "READ_UNCOMMITTED", "READ_COMMITTED", "REPEATABLE_READ", "SERIALIZABLE" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class).add(
//                new PropertyBinding("isolation", "locking/isolation", "java.lang.String", listType, this, false, false, true,
//                        "REPEATABLE_READ", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_66.register("isolation",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity,
//                            Object value) {
//                        entity.setIsolation((java.lang.String) value);
//                    }
//                });
//
//        mut_66.register("isolation",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache entity) {
//                        return entity.getIsolation();
//                    }
//                });
//
//        AddressBinding addr_66 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class, addr_66);
//        addr_66.add("subsystem", "infinispan");
//        addr_66.add("cache-container", "{0}");
//        addr_66.add("invalidation-cache", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache create() {
//                        return beanFactory.invalidationCache().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.InvalidationCache ----
//    }
//
//    public void ReplicatedCache_67() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_67 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class, mut_67);
//        label = "Name";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("name", "replicated-cache", "java.lang.String", listType, this, false, false, true, "",
//                        label, true, "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_67.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Concurrency Level";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("concurrencyLevel", "locking/concurrency-level", "java.lang.Integer", listType, this,
//                        false, false, true, "1000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("concurrencyLevel",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setConcurrencyLevel((java.lang.Integer) value);
//                    }
//                });
//
//        mut_67.register("concurrencyLevel",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getConcurrencyLevel();
//                    }
//                });
//
//        label = "Default for cache container?";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("default", "default-for-cache-container", "java.lang.Boolean", listType, this, false,
//                        false, true, "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("default", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setDefault((java.lang.Boolean) value);
//            }
//        });
//
//        mut_67.register("default", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.isDefault();
//            }
//        });
//
//        label = "Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] { "ASYNC", "SYNC" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("mode", "mode", "java.lang.String", listType, this, false, false, true, "ASYNC", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("mode", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setMode((java.lang.String) value);
//            }
//        });
//
//        mut_67.register("mode", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getMode();
//            }
//        });
//
//        label = "Queue Size";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("queueSize", "queue-size", "java.lang.Integer", listType, this, false, false, true, "1000",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("queueSize", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setQueueSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_67.register("queueSize", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getQueueSize();
//            }
//        });
//
//        label = "Batching";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("batching", "batching", "java.lang.Boolean", listType, this, false, false, true, "false",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("batching", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setBatching((java.lang.Boolean) value);
//            }
//        });
//
//        mut_67.register("batching", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.isBatching();
//            }
//        });
//
//        label = "Striping";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("striping", "locking/striping", "java.lang.Boolean", listType, this, false, false, true,
//                        "false", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("striping", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setStriping((java.lang.Boolean) value);
//            }
//        });
//
//        mut_67.register("striping", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.isStriping();
//            }
//        });
//
//        label = "Max Entries";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("maxEntries", "eviction/max-entries", "java.lang.Integer", listType, this, false, false,
//                        true, "10000", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("maxEntries", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setMaxEntries((java.lang.Integer) value);
//            }
//        });
//
//        mut_67.register("maxEntries", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getMaxEntries();
//            }
//        });
//
//        label = "Acquire Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("acquireTimeout", "locking/acquire-timeout", "java.lang.Long", listType, this, false,
//                        false, true, "15000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("acquireTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setAcquireTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_67.register("acquireTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getAcquireTimeout();
//                    }
//                });
//
//        label = "Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("interval", "expiration/interval", "java.lang.Long", listType, this, false, false, true,
//                        "5000", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("interval", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setInterval((java.lang.Long) value);
//            }
//        });
//
//        mut_67.register("interval", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getInterval();
//            }
//        });
//
//        label = "Lifespan";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("lifespan", "expiration/lifespan", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("lifespan", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setLifespan((java.lang.Long) value);
//            }
//        });
//
//        mut_67.register("lifespan", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getLifespan();
//            }
//        });
//
//        label = "Max Idle";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("maxIdle", "expiration/max-idle", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("maxIdle", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setMaxIdle((java.lang.Long) value);
//            }
//        });
//
//        mut_67.register("maxIdle", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getMaxIdle();
//            }
//        });
//
//        label = "Queue Flush Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("queueFlushInterval", "queue-flush-interval", "java.lang.Long", listType, this, false,
//                        false, true, "10", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("queueFlushInterval",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setQueueFlushInterval((java.lang.Long) value);
//                    }
//                });
//
//        mut_67.register("queueFlushInterval",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getQueueFlushInterval();
//                    }
//                });
//
//        label = "Remote Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("remoteTimeout", "remote-timeout", "java.lang.Long", listType, this, false, false, true,
//                        "17500", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("remoteTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setRemoteTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_67.register("remoteTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getRemoteTimeout();
//                    }
//                });
//
//        label = "Cache Container";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("cacheContainer", "cache-container", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "TEXT", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("cacheContainer",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setCacheContainer((java.lang.String) value);
//                    }
//                });
//
//        mut_67.register("cacheContainer",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getCacheContainer();
//                    }
//                });
//
//        label = "Controller Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "EAGER", "LAZY" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("controllerMode", "controller-mode", "java.lang.String", listType, this, false, false,
//                        true, "LAZY", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("controllerMode",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setControllerMode((java.lang.String) value);
//                    }
//                });
//
//        mut_67.register("controllerMode",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getControllerMode();
//                    }
//                });
//
//        label = "Eviction Strategy";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] { "NONE", "UNORDERED", "FIFO", "LRU", "LIRS" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("evictionStrategy", "eviction/strategy", "java.lang.String", listType, this, false, false,
//                        true, "NONE", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("evictionStrategy",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setEvictionStrategy((java.lang.String) value);
//                    }
//                });
//
//        mut_67.register("evictionStrategy",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getEvictionStrategy();
//                    }
//                });
//
//        label = "Indexing";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "NONE", "LOCAL", "ALL" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("indexing", "indexing", "java.lang.String", listType, this, false, false, true, "NONE",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("indexing", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setIndexing((java.lang.String) value);
//            }
//        });
//
//        mut_67.register("indexing", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getIndexing();
//            }
//        });
//
//        label = "Isolation";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] { "NONE", "READ_UNCOMMITTED", "READ_COMMITTED", "REPEATABLE_READ", "SERIALIZABLE" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("isolation", "locking/isolation", "java.lang.String", listType, this, false, false, true,
//                        "REPEATABLE_READ", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("isolation", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity, Object value) {
//                entity.setIsolation((java.lang.String) value);
//            }
//        });
//
//        mut_67.register("isolation", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                return entity.getIsolation();
//            }
//        });
//
//        label = "Enabled";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_stateTransfer();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("stateTransferEnabled", "state-transfer/enabled", "java.lang.Boolean", listType, this,
//                        false, false, true, "true", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("stateTransferEnabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setStateTransferEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_67.register("stateTransferEnabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.isStateTransferEnabled();
//                    }
//                });
//
//        label = "Flush Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_stateTransfer();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("stateTransferFlushTimeout", "state-tranfer/flush-timeout", "java.lang.Long", listType,
//                        this, false, false, true, "60000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_67.register("stateTransferFlushTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setStateTransferFlushTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_67.register("stateTransferFlushTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getStateTransferFlushTimeout();
//                    }
//                });
//
//        label = "Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_stateTransfer();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class).add(
//                new PropertyBinding("stateTransferTimeout", "state-tranfer/timeout", "java.lang.Long", listType, this, false,
//                        false, true, "60000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_67.register("stateTransferTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity,
//                            Object value) {
//                        entity.setStateTransferTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_67.register("stateTransferTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache entity) {
//                        return entity.getStateTransferTimeout();
//                    }
//                });
//
//        AddressBinding addr_67 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class, addr_67);
//        addr_67.add("subsystem", "infinispan");
//        addr_67.add("cache-container", "{0}");
//        addr_67.add("replicated-cache", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache create() {
//                        return beanFactory.replicatedCache().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.ReplicatedCache ----
//    }
//
//    public void DistributedCache_68() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_68 = new Mutator<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class, mut_68);
//        label = "Name";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("name", "distributed-cache", "java.lang.String", listType, this, false, false, true, "",
//                        label, true, "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("name", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_68.register("name", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Concurrency Level";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("concurrencyLevel", "locking/concurrency-level", "java.lang.Integer", listType, this,
//                        false, false, true, "1000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_68.register("concurrencyLevel",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setConcurrencyLevel((java.lang.Integer) value);
//                    }
//                });
//
//        mut_68.register("concurrencyLevel",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getConcurrencyLevel();
//                    }
//                });
//
//        label = "Default for cache container?";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("default", "default-for-cache-container", "java.lang.Boolean", listType, this, false,
//                        false, true, "false", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("default", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setDefault((java.lang.Boolean) value);
//            }
//        });
//
//        mut_68.register("default", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.isDefault();
//            }
//        });
//
//        label = "Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] { "ASYNC", "SYNC" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("mode", "mode", "java.lang.String", listType, this, false, false, true, "ASYNC", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("mode", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setMode((java.lang.String) value);
//            }
//        });
//
//        mut_68.register("mode", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getMode();
//            }
//        });
//
//        label = "Queue Size";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("queueSize", "queue-size", "java.lang.Integer", listType, this, false, false, true, "1000",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("queueSize", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setQueueSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_68.register("queueSize", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getQueueSize();
//            }
//        });
//
//        label = "Batching";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("batching", "batching", "java.lang.Boolean", listType, this, false, false, true, "false",
//                        label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("batching", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setBatching((java.lang.Boolean) value);
//            }
//        });
//
//        mut_68.register("batching", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.isBatching();
//            }
//        });
//
//        label = "Rehashing Enabled";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_distributed();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("rehashingEnabled", "rehashing/enabled", "java.lang.Boolean", listType, this, false, false,
//                        true, "true", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("rehashingEnabled",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setRehashingEnabled((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_68.register("rehashingEnabled",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.isRehashingEnabled();
//                    }
//                });
//
//        label = "Striping";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("striping", "locking/striping", "java.lang.Boolean", listType, this, false, false, true,
//                        "false", label, true, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("striping", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setStriping((java.lang.Boolean) value);
//            }
//        });
//
//        mut_68.register("striping", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.isStriping();
//            }
//        });
//
//        label = "L1 Lifespan";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_distributed();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("l1lifespan", "l1-lifespan", "java.lang.Integer", listType, this, false, false, true,
//                        "600000", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("l1lifespan",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setL1lifespan((java.lang.Integer) value);
//                    }
//                });
//
//        mut_68.register("l1lifespan",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getL1lifespan();
//                    }
//                });
//
//        label = "Max Entries";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("maxEntries", "eviction/max-entries", "java.lang.Integer", listType, this, false, false,
//                        true, "10000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("maxEntries",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setMaxEntries((java.lang.Integer) value);
//                    }
//                });
//
//        mut_68.register("maxEntries",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getMaxEntries();
//                    }
//                });
//
//        label = "Owners";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_distributed();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("owners", "owners", "java.lang.Integer", listType, this, false, false, true, "2", label,
//                        false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("owners", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setOwners((java.lang.Integer) value);
//            }
//        });
//
//        mut_68.register("owners", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getOwners();
//            }
//        });
//
//        label = "Virtual Nodes";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_distributed();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("virtualNodes", "virtual-nodes", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("virtualNodes",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setVirtualNodes((java.lang.Integer) value);
//                    }
//                });
//
//        mut_68.register("virtualNodes",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getVirtualNodes();
//                    }
//                });
//
//        label = "Acquire Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("acquireTimeout", "locking/acquire-timeout", "java.lang.Long", listType, this, false,
//                        false, true, "15000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("acquireTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setAcquireTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_68.register("acquireTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getAcquireTimeout();
//                    }
//                });
//
//        label = "Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("interval", "expiration/interval", "java.lang.Long", listType, this, false, false, true,
//                        "5000", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_68.register("interval", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setInterval((java.lang.Long) value);
//            }
//        });
//
//        mut_68.register("interval", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getInterval();
//            }
//        });
//
//        label = "Lifespan";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("lifespan", "expiration/lifespan", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_68.register("lifespan", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setLifespan((java.lang.Long) value);
//            }
//        });
//
//        mut_68.register("lifespan", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getLifespan();
//            }
//        });
//
//        label = "Max Idle";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_expiration();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("maxIdle", "expiration/max-idle", "java.lang.Long", listType, this, false, false, true,
//                        "-1", label, true, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_68.register("maxIdle", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setMaxIdle((java.lang.Long) value);
//            }
//        });
//
//        mut_68.register("maxIdle", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getMaxIdle();
//            }
//        });
//
//        label = "Queue Flush Interval";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("queueFlushInterval", "queue-flush-interval", "java.lang.Long", listType, this, false,
//                        false, true, "10", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("queueFlushInterval",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setQueueFlushInterval((java.lang.Long) value);
//                    }
//                });
//
//        mut_68.register("queueFlushInterval",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getQueueFlushInterval();
//                    }
//                });
//
//        label = "Remote Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_distributed();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("rehashingTimeout", "rehashing/timeout", "java.lang.Long", listType, this, false, false,
//                        true, "600000", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("rehashingTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setRehashingTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_68.register("rehashingTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getRehashingTimeout();
//                    }
//                });
//
//        label = "Remote Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_cluster();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("remoteTimeout", "remote-timeout", "java.lang.Long", listType, this, false, false, true,
//                        "17500", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("remoteTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setRemoteTimeout((java.lang.Long) value);
//                    }
//                });
//
//        mut_68.register("remoteTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getRemoteTimeout();
//                    }
//                });
//
//        label = "Cache Container";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("cacheContainer", "cache-container", "java.lang.String", listType, this, false, false,
//                        true, "", label, true, "TEXT", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("cacheContainer",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setCacheContainer((java.lang.String) value);
//                    }
//                });
//
//        mut_68.register("cacheContainer",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getCacheContainer();
//                    }
//                });
//
//        label = "Controller Mode";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "EAGER", "LAZY" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("controllerMode", "controller-mode", "java.lang.String", listType, this, false, false,
//                        true, "LAZY", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("controllerMode",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setControllerMode((java.lang.String) value);
//                    }
//                });
//
//        mut_68.register("controllerMode",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getControllerMode();
//                    }
//                });
//
//        label = "Eviction Strategy";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_eviction();
//        acceptedValues = new String[] { "NONE", "UNORDERED", "FIFO", "LRU", "LIRS" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("evictionStrategy", "eviction/strategy", "java.lang.String", listType, this, false, false,
//                        true, "NONE", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("evictionStrategy",
//                new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity,
//                            Object value) {
//                        entity.setEvictionStrategy((java.lang.String) value);
//                    }
//                });
//
//        mut_68.register("evictionStrategy",
//                new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                        return entity.getEvictionStrategy();
//                    }
//                });
//
//        label = "Indexing";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "NONE", "LOCAL", "ALL" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("indexing", "indexing", "java.lang.String", listType, this, false, false, true, "NONE",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("indexing", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setIndexing((java.lang.String) value);
//            }
//        });
//
//        mut_68.register("indexing", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getIndexing();
//            }
//        });
//
//        label = "Isolation";
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_infinispan_locking();
//        acceptedValues = new String[] { "NONE", "READ_UNCOMMITTED", "READ_COMMITTED", "REPEATABLE_READ", "SERIALIZABLE" };
//        registry.get(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class).add(
//                new PropertyBinding("isolation", "locking/isolation", "java.lang.String", listType, this, false, false, true,
//                        "REPEATABLE_READ", label, true, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_68.register("isolation", new Setter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity, Object value) {
//                entity.setIsolation((java.lang.String) value);
//            }
//        });
//
//        mut_68.register("isolation", new Getter<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache entity) {
//                return entity.getIsolation();
//            }
//        });
//
//        AddressBinding addr_68 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class, addr_68);
//        addr_68.add("subsystem", "infinispan");
//        addr_68.add("cache-container", "{0}");
//        addr_68.add("distributed-cache", "{1}");
//        factories.put(org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache>() {
//                    public org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache create() {
//                        return beanFactory.distributedCache().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.infinispan.model.DistributedCache ----
//    }
//
//    public void ThreadFactory_69() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_69 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class, mut_69);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_69.register("name", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_69.register("name", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Priority";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class).add(
//                new PropertyBinding("priority", "priority", "java.lang.String", listType, this, false, false, true, "1", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_69.register("priority", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity, Object value) {
//                entity.setPriority((java.lang.String) value);
//            }
//        });
//
//        mut_69.register("priority", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity) {
//                return entity.getPriority();
//            }
//        });
//
//        label = "Group Name";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class).add(
//                new PropertyBinding("groupName", "group-name", "java.lang.String", listType, this, false, false, true,
//                        "FormItem#undefined", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_69.register("groupName", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity, Object value) {
//                entity.setGroupName((java.lang.String) value);
//            }
//        });
//
//        mut_69.register("groupName", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity) {
//                return entity.getGroupName();
//            }
//        });
//
//        label = "Thread Name Pattern";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class).add(
//                new PropertyBinding("threadNamePattern", "thread-name-pattern", "java.lang.String", listType, this, false,
//                        false, true, "FormItem#undefined", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_69.register("threadNamePattern",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity,
//                            Object value) {
//                        entity.setThreadNamePattern((java.lang.String) value);
//                    }
//                });
//
//        mut_69.register("threadNamePattern",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory entity) {
//                        return entity.getThreadNamePattern();
//                    }
//                });
//
//        AddressBinding addr_69 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class, addr_69);
//        addr_69.add("subsystem", "threads");
//        addr_69.add("thread-factory", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory create() {
//                        return beanFactory.threadFactory().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.ThreadFactory ----
//    }
//
//    public void BoundedQueueThreadPool_70() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_70 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class, mut_70);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_70.register("name", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                    Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_70.register("name", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Queue Length";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("queueLength", "queue-length", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("queueLength",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setQueueLength((java.lang.Integer) value);
//                    }
//                });
//
//        mut_70.register("queueLength",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getQueueLength();
//                    }
//                });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_70.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Allow Core Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("allowCoreTimeout", "allow-core-timeout", "java.lang.Boolean", listType, this, false,
//                        false, true, "true", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("allowCoreTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setAllowCoreTimeout((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_70.register("allowCoreTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.isAllowCoreTimeout();
//                    }
//                });
//
//        label = "Core Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("coreThreads", "core-threads", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("coreThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setCoreThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_70.register("coreThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getCoreThreads();
//                    }
//                });
//
//        label = "Keepalive Time";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("keepaliveTime", "keepalive-time/time", "java.lang.Long", listType, this, false, false,
//                        true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("keepaliveTime",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTime((java.lang.Long) value);
//                    }
//                });
//
//        mut_70.register("keepaliveTime",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTime();
//                    }
//                });
//
//        label = "Handoff Executor";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("handoffExecutor", "handoff-executor", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("handoffExecutor",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setHandoffExecutor((java.lang.String) value);
//                    }
//                });
//
//        mut_70.register("handoffExecutor",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getHandoffExecutor();
//                    }
//                });
//
//        label = "Keepalive Time Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class)
//                .add(new PropertyBinding("keepaliveTimeUnit", "keepalive-time/unit", "java.lang.String", listType, this, false,
//                        false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("keepaliveTimeUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_70.register("keepaliveTimeUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTimeUnit();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_70.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_70.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        AddressBinding addr_70 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class, addr_70);
//        addr_70.add("subsystem", "threads");
//        addr_70.add("bounded-queue-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool create() {
//                        return beanFactory.boundedQueueThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.BoundedQueueThreadPool ----
//    }
//
//    public void BlockingBoundedQueueThreadPool_71() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_71 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class, mut_71);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_71.register("name",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setName((java.lang.String) value);
//                    }
//                });
//
//        mut_71.register("name",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getName();
//                    }
//                });
//
//        label = "Queue Length";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("queueLength", "queue-length", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("queueLength",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setQueueLength((java.lang.Integer) value);
//                    }
//                });
//
//        mut_71.register("queueLength",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getQueueLength();
//                    }
//                });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_71.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Allow Core Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("allowCoreTimeout", "allow-core-timeout", "java.lang.Boolean", listType, this, false,
//                        false, true, "true", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("allowCoreTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setAllowCoreTimeout((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_71.register("allowCoreTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.isAllowCoreTimeout();
//                    }
//                });
//
//        label = "Core Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("coreThreads", "core-threads", "java.lang.Integer", listType, this, false, false, true,
//                        "2", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("coreThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setCoreThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_71.register("coreThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getCoreThreads();
//                    }
//                });
//
//        label = "Keepalive Time";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("keepaliveTime", "keepalive-time/time", "java.lang.Long", listType, this, false, false,
//                        true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("keepaliveTime",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTime((java.lang.Long) value);
//                    }
//                });
//
//        mut_71.register("keepaliveTime",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTime();
//                    }
//                });
//
//        label = "Keepalive Time Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class)
//                .add(new PropertyBinding("keepaliveTimeUnit", "keepalive-time/unit", "java.lang.String", listType, this, false,
//                        false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("keepaliveTimeUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_71.register("keepaliveTimeUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTimeUnit();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_71.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_71.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        AddressBinding addr_71 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class, addr_71);
//        addr_71.add("subsystem", "threads");
//        addr_71.add("blocking-bounded-queue-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool create() {
//                        return beanFactory.blockingBoundedQueueThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.BlockingBoundedQueueThreadPool ----
//    }
//
//    public void UnboundedQueueThreadPool_72() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_72 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class, mut_72);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_72.register("name", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity,
//                    Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_72.register("name", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_72.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_72.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_72.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_72.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        label = "Keepalive Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeout", "keepalive-time/time", "java.lang.Integer", listType, this, false,
//                        false, true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_72.register("keepaliveTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeout((java.lang.Integer) value);
//                    }
//                });
//
//        mut_72.register("keepaliveTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTimeout();
//                    }
//                });
//
//        label = "Keepalive Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class)
//                .add(new PropertyBinding("keepaliveTimeoutUnit", "keepalive-time/unit", "java.lang.String", listType, this,
//                        false, false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_72.register("keepaliveTimeoutUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeoutUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_72.register("keepaliveTimeoutUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool entity) {
//                        return entity.getKeepaliveTimeoutUnit();
//                    }
//                });
//
//        AddressBinding addr_72 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class, addr_72);
//        addr_72.add("subsystem", "threads");
//        addr_72.add("unbounded-queue-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool create() {
//                        return beanFactory.unboundedQueueThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.UnboundedQueueThreadPool ----
//    }
//
//    public void QueuelessThreadPool_73() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_73 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class, mut_73);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_73.register("name", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_73.register("name", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_73.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_73.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Handoff Executor";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("handoffExecutor", "handoff-executor", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_73.register("handoffExecutor",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity,
//                            Object value) {
//                        entity.setHandoffExecutor((java.lang.String) value);
//                    }
//                });
//
//        mut_73.register("handoffExecutor",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                        return entity.getHandoffExecutor();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_73.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_73.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        label = "Keepalive Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeout", "keepalive-time/time", "java.lang.Integer", listType, this, false,
//                        false, true, "60", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_73.register("keepaliveTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeout((java.lang.Integer) value);
//                    }
//                });
//
//        mut_73.register("keepaliveTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                        return entity.getKeepaliveTimeout();
//                    }
//                });
//
//        label = "Keepalive Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeoutUnit", "keepalive-time/unit", "java.lang.String", listType, this, false,
//                        false, true, "SECONDS", label, false, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_73.register("keepaliveTimeoutUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeoutUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_73.register("keepaliveTimeoutUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool entity) {
//                        return entity.getKeepaliveTimeoutUnit();
//                    }
//                });
//
//        AddressBinding addr_73 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class, addr_73);
//        addr_73.add("subsystem", "threads");
//        addr_73.add("queueless-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool create() {
//                        return beanFactory.queuelessThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.QueuelessThreadPool ----
//    }
//
//    public void BlockingQueuelessThreadPool_74() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_74 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class, mut_74);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_74.register("name",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity,
//                            Object value) {
//                        entity.setName((java.lang.String) value);
//                    }
//                });
//
//        mut_74.register("name",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity) {
//                        return entity.getName();
//                    }
//                });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_74.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_74.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_74.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_74.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        label = "Keepalive Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeout", "keepalive-time/time", "java.lang.Integer", listType, this, false,
//                        false, true, "60", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_74.register("keepaliveTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeout((java.lang.Integer) value);
//                    }
//                });
//
//        mut_74.register("keepaliveTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity) {
//                        return entity.getKeepaliveTimeout();
//                    }
//                });
//
//        label = "Keepalive Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeoutUnit", "keepalive-time/unit", "java.lang.String", listType, this, false,
//                        false, true, "SECONDS", label, false, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_74.register("keepaliveTimeoutUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeoutUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_74.register("keepaliveTimeoutUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool entity) {
//                        return entity.getKeepaliveTimeoutUnit();
//                    }
//                });
//
//        AddressBinding addr_74 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class, addr_74);
//        addr_74.add("subsystem", "threads");
//        addr_74.add("blocking-queueless-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool create() {
//                        return beanFactory.blockingQueuelessThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.BlockingQueuelessThreadPool ----
//    }
//
//    public void ScheduledThreadPool_75() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_75 = new Mutator<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class, mut_75);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 0, acceptedValues));
//        mut_75.register("name", new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_75.register("name", new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "Max Threads";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "2",
//                        label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_75.register("maxThreads",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity,
//                            Object value) {
//                        entity.setMaxThreads((java.lang.Integer) value);
//                    }
//                });
//
//        mut_75.register("maxThreads",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity) {
//                        return entity.getMaxThreads();
//                    }
//                });
//
//        label = "Thread Factory";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class).add(
//                new PropertyBinding("threadFactory", "thread-factory", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_75.register("threadFactory",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity,
//                            Object value) {
//                        entity.setThreadFactory((java.lang.String) value);
//                    }
//                });
//
//        mut_75.register("threadFactory",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity) {
//                        return entity.getThreadFactory();
//                    }
//                });
//
//        label = "Keepalive Timeout";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class).add(
//                new PropertyBinding("keepaliveTimeout", "keepalive-time/time", "java.lang.Integer", listType, this, false,
//                        false, true, "60", label, true, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_75.register("keepaliveTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeout((java.lang.Integer) value);
//                    }
//                });
//
//        mut_75.register("keepaliveTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity) {
//                        return entity.getKeepaliveTimeout();
//                    }
//                });
//
//        label = "Keepalive Timeout Unit";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class)
//                .add(new PropertyBinding("keepaliveTimeoutUnit", "keepalive-time/unit", "java.lang.String", listType, this,
//                        false, false, true, "SECONDS", label, true, "TIME_UNITS", "TIME_UNITS", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_75.register("keepaliveTimeoutUnit",
//                new Setter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity,
//                            Object value) {
//                        entity.setKeepaliveTimeoutUnit((java.lang.String) value);
//                    }
//                });
//
//        mut_75.register("keepaliveTimeoutUnit",
//                new Getter<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool entity) {
//                        return entity.getKeepaliveTimeoutUnit();
//                    }
//                });
//
//        AddressBinding addr_75 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class, addr_75);
//        addr_75.add("subsystem", "threads");
//        addr_75.add("scheduled-thread-pool", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool>() {
//                    public org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool create() {
//                        return beanFactory.scheduledThreadPool().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.threads.model.ScheduledThreadPool ----
//    }
//
//    public void TransactionManager_76() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_76 = new Mutator<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class, mut_76);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("path", "path", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("path", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setPath((java.lang.String) value);
//            }
//        });
//
//        mut_76.register("path", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getPath();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("socketBinding", "socket-binding", "java.lang.String", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("socketBinding", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setSocketBinding((java.lang.String) value);
//            }
//        });
//
//        mut_76.register("socketBinding", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getSocketBinding();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("relativeTo", "relative-to", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("relativeTo", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setRelativeTo((java.lang.String) value);
//            }
//        });
//
//        mut_76.register("relativeTo", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getRelativeTo();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("enableStatistics", "enable-statistics", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("enableStatistics",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setEnableStatistics((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_76.register("enableStatistics",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.isEnableStatistics();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("enableTsmStatus", "enable-tsm-status", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("enableTsmStatus", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setEnableTsmStatus((java.lang.Boolean) value);
//            }
//        });
//
//        mut_76.register("enableTsmStatus", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.isEnableTsmStatus();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("recoveryListener", "recovery-listener", "java.lang.Boolean", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("recoveryListener",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setRecoveryListener((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_76.register("recoveryListener",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.isRecoveryListener();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("defaultTimeout", "default-timeout", "java.lang.Integer", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("defaultTimeout", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setDefaultTimeout((java.lang.Integer) value);
//            }
//        });
//
//        mut_76.register("defaultTimeout", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getDefaultTimeout();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("objectStorePath", "object-store-path", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("objectStorePath", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setObjectStorePath((java.lang.String) value);
//            }
//        });
//
//        mut_76.register("objectStorePath", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getObjectStorePath();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("objectStoreRelativeTo", "object-store-relative-to", "java.lang.String", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("objectStoreRelativeTo",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setObjectStoreRelativeTo((java.lang.String) value);
//                    }
//                });
//
//        mut_76.register("objectStoreRelativeTo",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getObjectStoreRelativeTo();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("statusSocketBinding", "status-socket-binding", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("statusSocketBinding",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setStatusSocketBinding((java.lang.String) value);
//                    }
//                });
//
//        mut_76.register("statusSocketBinding",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getStatusSocketBinding();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numAbortedTransactions", "number-of-aborted-transactions", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_76.register("numAbortedTransactions",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumAbortedTransactions((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numAbortedTransactions",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumAbortedTransactions();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numApplicationRollback", "number-of-application-rollbacks", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_76.register("numApplicationRollback",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumApplicationRollback((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numApplicationRollback",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumApplicationRollback();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numCommittedTransactions", "number-of-committed-transactions", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_76.register("numCommittedTransactions",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumCommittedTransactions((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numCommittedTransactions",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumCommittedTransactions();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numHeuristics", "number-of-heuristics", "java.lang.Long", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("numHeuristics", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setNumHeuristics((java.lang.Long) value);
//            }
//        });
//
//        mut_76.register("numHeuristics", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getNumHeuristics();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numInflightTransactions", "number-of-inflight-transactions", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_76.register("numInflightTransactions",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumInflightTransactions((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numInflightTransactions",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumInflightTransactions();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numNestedTransactions", "number-of-nested-transactions", "java.lang.Long", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("numNestedTransactions",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumNestedTransactions((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numNestedTransactions",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumNestedTransactions();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numResourceRollback", "number-of-resource-rollbacks", "java.lang.Long", listType, this,
//                        false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("numResourceRollback",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumResourceRollback((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numResourceRollback",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumResourceRollback();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numTimeoutTransactions", "number-of-timed-out-transactions", "java.lang.Long", listType,
//                        this, false, false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100,
//                        acceptedValues));
//        mut_76.register("numTimeoutTransactions",
//                new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity,
//                            Object value) {
//                        entity.setNumTimeoutTransactions((java.lang.Long) value);
//                    }
//                });
//
//        mut_76.register("numTimeoutTransactions",
//                new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                        return entity.getNumTimeoutTransactions();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class).add(
//                new PropertyBinding("numTransactions", "number-of-transactions", "java.lang.Long", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_76.register("numTransactions", new Setter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity, Object value) {
//                entity.setNumTransactions((java.lang.Long) value);
//            }
//        });
//
//        mut_76.register("numTransactions", new Getter<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager entity) {
//                return entity.getNumTransactions();
//            }
//        });
//
//        AddressBinding addr_76 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class, addr_76);
//        addr_76.add("subsystem", "transactions");
//        factories.put(org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager>() {
//                    public org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager create() {
//                        return beanFactory.transactionManager().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.tx.model.TransactionManager ----
//    }
//
//    public void SecuritySubsystem_77() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_77 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem.class, mut_77);
//        label = Console.CONSTANTS.subsys_security_deepCopySubjects();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem.class).add(
//                new PropertyBinding("deepCopySubjects", "deep-copy-subject-mode", "java.lang.Boolean", listType, this, false,
//                        false, true, "", label, false, "CHECK_BOX", "CHECK_BOX", subgroup, tabName, 10, acceptedValues));
//        mut_77.register("deepCopySubjects",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem entity,
//                            Object value) {
//                        entity.setDeepCopySubjects((java.lang.Boolean) value);
//                    }
//                });
//
//        mut_77.register("deepCopySubjects",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem entity) {
//                        return entity.isDeepCopySubjects();
//                    }
//                });
//
//        AddressBinding addr_77 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem.class, addr_77);
//        addr_77.add("subsystem", "security");
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem create() {
//                        return beanFactory.securitySubsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.SecuritySubsystem ----
//    }
//
//    public void SecurityDomain_78() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_78 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class, mut_78);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_78.register("name", new Setter<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_78.register("name", new Getter<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_security_cacheType();
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] { "default", "infinispan" };
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class).add(
//                new PropertyBinding("cacheType", "cache-type", "java.lang.String", listType, this, false, false, true,
//                        "default", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_78.register("cacheType", new Setter<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain entity, Object value) {
//                entity.setCacheType((java.lang.String) value);
//            }
//        });
//
//        mut_78.register("cacheType", new Getter<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain entity) {
//                return entity.getCacheType();
//            }
//        });
//
//        AddressBinding addr_78 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class, addr_78);
//        addr_78.add("subsystem", "security");
//        addr_78.add("security-domain", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain create() {
//                        return beanFactory.securityDomain().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain ----
//    }
//
//    public void AuthenticationLoginModule_79() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_79 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class, mut_79);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class).add(
//                new PropertyBinding("flag", "flag", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_79.register("flag",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity,
//                            Object value) {
//                        entity.setFlag((java.lang.String) value);
//                    }
//                });
//
//        mut_79.register("flag",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity) {
//                        return entity.getFlag();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_79.register("properties",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity,
//                            Object value) {
//                        entity.setProperties((java.util.List) value);
//                    }
//                });
//
//        mut_79.register("properties",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity) {
//                        return entity.getProperties();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class).add(
//                new PropertyBinding("code", "code", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_79.register("code",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity,
//                            Object value) {
//                        entity.setCode((java.lang.String) value);
//                    }
//                });
//
//        mut_79.register("code",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule entity) {
//                        return entity.getCode();
//                    }
//                });
//
//        AddressBinding addr_79 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class, addr_79);
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule create() {
//                        return beanFactory.authenticationLoginModule().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.AuthenticationLoginModule ----
//    }
//
//    public void AuthorizationPolicyProvider_80() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_80 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class, mut_80);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class).add(
//                new PropertyBinding("flag", "flag", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_80.register("flag",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity,
//                            Object value) {
//                        entity.setFlag((java.lang.String) value);
//                    }
//                });
//
//        mut_80.register("flag",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity) {
//                        return entity.getFlag();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_80.register("properties",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity,
//                            Object value) {
//                        entity.setProperties((java.util.List) value);
//                    }
//                });
//
//        mut_80.register("properties",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity) {
//                        return entity.getProperties();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class).add(
//                new PropertyBinding("code", "code", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_80.register("code",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity,
//                            Object value) {
//                        entity.setCode((java.lang.String) value);
//                    }
//                });
//
//        mut_80.register("code",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider entity) {
//                        return entity.getCode();
//                    }
//                });
//
//        AddressBinding addr_80 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class, addr_80);
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider create() {
//                        return beanFactory.authorizationPolicyModule().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.AuthorizationPolicyProvider ----
//    }
//
//    public void MappingModule_81() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_81 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class, mut_81);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class).add(
//                new PropertyBinding("type", "type", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_81.register("type", new Setter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity, Object value) {
//                entity.setType((java.lang.String) value);
//            }
//        });
//
//        mut_81.register("type", new Getter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity) {
//                return entity.getType();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_81.register("properties", new Setter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity, Object value) {
//                entity.setProperties((java.util.List) value);
//            }
//        });
//
//        mut_81.register("properties", new Getter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity) {
//                return entity.getProperties();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class).add(
//                new PropertyBinding("code", "code", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_81.register("code", new Setter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity, Object value) {
//                entity.setCode((java.lang.String) value);
//            }
//        });
//
//        mut_81.register("code", new Getter<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.security.model.MappingModule entity) {
//                return entity.getCode();
//            }
//        });
//
//        AddressBinding addr_81 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class, addr_81);
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.MappingModule.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.MappingModule>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.MappingModule create() {
//                        return beanFactory.mappingModule().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.MappingModule ----
//    }
//
//    public void GenericSecurityDomainData_82() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_82 = new Mutator<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class, mut_82);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_82.register("properties",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData entity,
//                            Object value) {
//                        entity.setProperties((java.util.List) value);
//                    }
//                });
//
//        mut_82.register("properties",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData entity) {
//                        return entity.getProperties();
//                    }
//                });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class).add(
//                new PropertyBinding("code", "code", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_82.register("code",
//                new Setter<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>() {
//                    public void invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData entity,
//                            Object value) {
//                        entity.setCode((java.lang.String) value);
//                    }
//                });
//
//        mut_82.register("code",
//                new Getter<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>() {
//                    public Object invoke(
//                            org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData entity) {
//                        return entity.getCode();
//                    }
//                });
//
//        AddressBinding addr_82 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class, addr_82);
//        factories.put(org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData>() {
//                    public org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData create() {
//                        return beanFactory.genericSecurityDomainData().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.security.model.GenericSecurityDomainData ----
//    }
//
//    public void JpaSubsystem_83() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem.class, new ArrayList<PropertyBinding>());
//        Mutator mut_83 = new Mutator<org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem.class, mut_83);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem.class).add(
//                new PropertyBinding("defaultDataSource", "default-datasource", "java.lang.String", listType, this, false,
//                        false, true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_83.register("defaultDataSource", new Setter<org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem entity, Object value) {
//                entity.setDefaultDataSource((java.lang.String) value);
//            }
//        });
//
//        mut_83.register("defaultDataSource", new Getter<org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem entity) {
//                return entity.getDefaultDataSource();
//            }
//        });
//
//        AddressBinding addr_83 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem.class, addr_83);
//        addr_83.add("subsystem", "jpa");
//        factories.put(org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem create() {
//                        return beanFactory.jpaSubystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jpa.model.JpaSubsystem ----
//    }
//
//    public void MailSession_84() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.mail.MailSession.class, new ArrayList<PropertyBinding>());
//        Mutator mut_84 = new Mutator<org.jboss.as.console.client.shared.subsys.mail.MailSession>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.mail.MailSession.class, mut_84);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.mail.MailSession.class).add(
//                new PropertyBinding("jndiName", "jndi-name", "java.lang.String", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_84.register("jndiName", new Setter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity, Object value) {
//                entity.setJndiName((java.lang.String) value);
//            }
//        });
//
//        mut_84.register("jndiName", new Getter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity) {
//                return entity.getJndiName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.mail.MailSession.class).add(
//                new PropertyBinding("debug", "debug", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_84.register("debug", new Setter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity, Object value) {
//                entity.setDebug((java.lang.Boolean) value);
//            }
//        });
//
//        mut_84.register("debug", new Getter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity) {
//                return entity.isDebug();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.mail.MailSession.class).add(
//                new PropertyBinding("imapServer", "imap-server", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_84.register("imapServer", new Setter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity, Object value) {
//                entity.setImapServer((java.lang.String) value);
//            }
//        });
//
//        mut_84.register("imapServer", new Getter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity) {
//                return entity.getImapServer();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.mail.MailSession.class).add(
//                new PropertyBinding("popServer", "pop3-server", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_84.register("popServer", new Setter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity, Object value) {
//                entity.setPopServer((java.lang.String) value);
//            }
//        });
//
//        mut_84.register("popServer", new Getter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity) {
//                return entity.getPopServer();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.mail.MailSession.class).add(
//                new PropertyBinding("smtpServer", "smtp-server", "java.lang.String", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_84.register("smtpServer", new Setter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity, Object value) {
//                entity.setSmtpServer((java.lang.String) value);
//            }
//        });
//
//        mut_84.register("smtpServer", new Getter<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.mail.MailSession entity) {
//                return entity.getSmtpServer();
//            }
//        });
//
//        AddressBinding addr_84 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.mail.MailSession.class, addr_84);
//        addr_84.add("subsystem", "mail");
//        addr_84.add("mail-session", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.mail.MailSession.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.mail.MailSession>() {
//                    public org.jboss.as.console.client.shared.subsys.mail.MailSession create() {
//                        return beanFactory.mailSession().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.mail.MailSession ----
//    }
//
//    public void JcaArchiveValidation_85() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_85 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class, mut_85);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_85.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_85.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class).add(
//                new PropertyBinding("failOnError", "fail-on-error", "java.lang.Boolean", listType, this, false, false, true,
//                        "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_85.register("failOnError", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity, Object value) {
//                entity.setFailOnError((java.lang.Boolean) value);
//            }
//        });
//
//        mut_85.register("failOnError", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity) {
//                return entity.isFailOnError();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class).add(
//                new PropertyBinding("failOnWarn", "fail-on-warn", "java.lang.Boolean", listType, this, false, false, true, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_85.register("failOnWarn", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity, Object value) {
//                entity.setFailOnWarn((java.lang.Boolean) value);
//            }
//        });
//
//        mut_85.register("failOnWarn", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation entity) {
//                return entity.isFailOnWarn();
//            }
//        });
//
//        AddressBinding addr_85 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class, addr_85);
//        addr_85.add("subsystem", "jca");
//        addr_85.add("archive-validation", "archive-validation");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation create() {
//                        return beanFactory.JcaArchiveValidation().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.JcaArchiveValidation ----
//    }
//
//    public void JcaBootstrapContext_86() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_86 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class, mut_86);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_86.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_86.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext entity) {
//                return entity.getName();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class).add(
//                new PropertyBinding("workmanager", "workmanager", "java.lang.String", listType, this, false, false, false, "",
//                        label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_86.register("workmanager", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext entity, Object value) {
//                entity.setWorkmanager((java.lang.String) value);
//            }
//        });
//
//        mut_86.register("workmanager", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext entity) {
//                return entity.getWorkmanager();
//            }
//        });
//
//        AddressBinding addr_86 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class, addr_86);
//        addr_86.add("subsystem", "jca");
//        addr_86.add("bootstrap-context", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext create() {
//                        return beanFactory.JcaBootstrapContext().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.JcaBootstrapContext ----
//    }
//
//    public void JcaBeanValidation_87() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation.class, new ArrayList<PropertyBinding>());
//        Mutator mut_87 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation.class, mut_87);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation.class).add(
//                new PropertyBinding("enabled", "enabled", "java.lang.Boolean", listType, this, false, false, true, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_87.register("enabled", new Setter<org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation entity, Object value) {
//                entity.setEnabled((java.lang.Boolean) value);
//            }
//        });
//
//        mut_87.register("enabled", new Getter<org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation entity) {
//                return entity.isEnabled();
//            }
//        });
//
//        AddressBinding addr_87 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation.class, addr_87);
//        addr_87.add("subsystem", "jca");
//        addr_87.add("bean-validation", "bean-validation");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation create() {
//                        return beanFactory.JcaBeanValidation().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.JcaBeanValidation ----
//    }
//
//    public void JcaWorkmanager_88() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager.class, new ArrayList<PropertyBinding>());
//        Mutator mut_88 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager.class, mut_88);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, false, false, false, "", label, false,
//                        "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_88.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_88.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager entity) {
//                return entity.getName();
//            }
//        });
//
//        AddressBinding addr_88 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager.class, addr_88);
//        addr_88.add("subsystem", "jca");
//        addr_88.add("workmanager", "{0}");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager create() {
//                        return beanFactory.JcaWorkmanager().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.JcaWorkmanager ----
//    }
//
//    public void JcaConnectionManager_89() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_89 = new Mutator<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class, mut_89);
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class).add(
//                new PropertyBinding("error", "error", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_89.register("error", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager entity, Object value) {
//                entity.setError((java.lang.Boolean) value);
//            }
//        });
//
//        mut_89.register("error", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager entity) {
//                return entity.isError();
//            }
//        });
//
//        label = "";
//        subgroup = "";
//        tabName = Console.CONSTANTS.common_label_attributes();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class).add(
//                new PropertyBinding("debug", "debug", "java.lang.Boolean", listType, this, false, false, false, "", label,
//                        false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_89.register("debug", new Setter<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager entity, Object value) {
//                entity.setDebug((java.lang.Boolean) value);
//            }
//        });
//
//        mut_89.register("debug", new Getter<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager entity) {
//                return entity.isDebug();
//            }
//        });
//
//        AddressBinding addr_89 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class, addr_89);
//        addr_89.add("subsystem", "jca");
//        addr_89.add("cached-connection-manager", "cached-connection-manager");
//        factories.put(org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager>() {
//                    public org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager create() {
//                        return beanFactory.JcaConnectionManager().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jca.model.JcaConnectionManager ----
//    }
//
//    public void JacOrbSubsystem_90() {
//        Class<?> listType = null;
//        String label = "";
//        String subgroup = "";
//        String tabName = "";
//        String[] acceptedValues = null;
//
//        registry.put(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class,
//                new ArrayList<PropertyBinding>());
//        Mutator mut_90 = new Mutator<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>();
//        mutators.put(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class, mut_90);
//        label = Console.CONSTANTS.common_label_name();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("name", "name", "java.lang.String", listType, this, true, false, true, "", label, true,
//                        "TEXT", "TEXT_BOX", subgroup, tabName, 10, acceptedValues));
//        mut_90.register("name", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setName((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("name", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getName();
//            }
//        });
//
//        label = Console.CONSTANTS.common_label_properties();
//        listType = org.jboss.as.console.client.shared.properties.PropertyRecord.class;
//        subgroup = "";
//        tabName = "CUSTOM";
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("properties", "properties", "java.util.List", listType, this, false, false, true, "",
//                        label, false, "PROPERTY_EDITOR", "PROPERTY_EDITOR", subgroup, tabName, 1000, acceptedValues));
//        mut_90.register("properties", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setProperties((java.util.List) value);
//            }
//        });
//
//        mut_90.register("properties", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getProperties();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_maxThreads();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("maxThreads", "max-threads", "java.lang.Integer", listType, this, false, false, true, "32",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 230, acceptedValues));
//        mut_90.register("maxThreads", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setMaxThreads((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("maxThreads", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getMaxThreads();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_securityDomain();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("securityDomain", "security-domain", "java.lang.String", listType, this, false, false,
//                        true, "", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 340, acceptedValues));
//        mut_90.register("securityDomain", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setSecurityDomain((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("securityDomain", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getSecurityDomain();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_clientTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("clientTimeout", "client-timeout", "java.lang.Integer", listType, this, false, false, true,
//                        "0", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 100, acceptedValues));
//        mut_90.register("clientTimeout", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setClientTimeout((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("clientTimeout", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getClientTimeout();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_GIOPMinorVersion();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("giopMinorVersion", "giop-minor-version", "java.lang.Integer", listType, this, false,
//                        false, true, "2", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 70, acceptedValues));
//        mut_90.register("giopMinorVersion",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setGiopMinorVersion((java.lang.Integer) value);
//                    }
//                });
//
//        mut_90.register("giopMinorVersion",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getGiopMinorVersion();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_maxManagedBufSize();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("maxManagedBufSize", "max-managed-buf-size", "java.lang.Integer", listType, this, false,
//                        false, true, "24", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 130, acceptedValues));
//        mut_90.register("maxManagedBufSize",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setMaxManagedBufSize((java.lang.Integer) value);
//                    }
//                });
//
//        mut_90.register("maxManagedBufSize",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getMaxManagedBufSize();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_maxServerConnections();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("maxServerConnections", "max-server-connections", "java.lang.Integer", listType, this,
//                        false, false, true, "2147483647", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 120,
//                        acceptedValues));
//        mut_90.register("maxServerConnections",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setMaxServerConnections((java.lang.Integer) value);
//                    }
//                });
//
//        mut_90.register("maxServerConnections",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getMaxServerConnections();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_outbufCacheTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("outbufCacheTimeout", "outbuf-cache-timeout", "java.lang.Integer", listType, this, false,
//                        false, true, "-1", label, false, "NUMBER_BOX_ALLOW_NEGATIVE", "NUMBER_BOX_ALLOW_NEGATIVE", subgroup,
//                        tabName, 150, acceptedValues));
//        mut_90.register("outbufCacheTimeout",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setOutbufCacheTimeout((java.lang.Integer) value);
//                    }
//                });
//
//        mut_90.register("outbufCacheTimeout",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getOutbufCacheTimeout();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_outbufSize();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("outbufSize", "outbuf-size", "java.lang.Integer", listType, this, false, false, true,
//                        "2048", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 140, acceptedValues));
//        mut_90.register("outbufSize", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setOutbufSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("outbufSize", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getOutbufSize();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_poolSize();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("poolSize", "pool-size", "java.lang.Integer", listType, this, false, false, true, "5",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 220, acceptedValues));
//        mut_90.register("poolSize", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setPoolSize((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("poolSize", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getPoolSize();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_queueMax();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("queueMax", "queue-max", "java.lang.Integer", listType, this, false, false, true, "100",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 210, acceptedValues));
//        mut_90.register("queueMax", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setQueueMax((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("queueMax", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getQueueMax();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_queueMin();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("queueMin", "queue-min", "java.lang.Integer", listType, this, false, false, true, "10",
//                        label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 200, acceptedValues));
//        mut_90.register("queueMin", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setQueueMin((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("queueMin", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getQueueMin();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_retries();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("retries", "retries", "java.lang.Integer", listType, this, false, false, true, "5", label,
//                        false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 80, acceptedValues));
//        mut_90.register("retries", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setRetries((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("retries", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getRetries();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_retryInterval();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("retryInterval", "retry-interval", "java.lang.Integer", listType, this, false, false, true,
//                        "500", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 90, acceptedValues));
//        mut_90.register("retryInterval", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setRetryInterval((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("retryInterval", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getRetryInterval();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_serverTimeout();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("serverTimeout", "server-timeout", "java.lang.Integer", listType, this, false, false, true,
//                        "0", label, false, "NUMBER_BOX", "NUMBER_BOX", subgroup, tabName, 110, acceptedValues));
//        mut_90.register("serverTimeout", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setServerTimeout((java.lang.Integer) value);
//            }
//        });
//
//        mut_90.register("serverTimeout", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getServerTimeout();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_addComponentViaInterceptor();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("addComponentViaInterceptor", "add-component-via-interceptor", "java.lang.String",
//                        listType, this, false, false, true, "on", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName,
//                        350, acceptedValues));
//        mut_90.register("addComponentViaInterceptor",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setAddComponentViaInterceptor((java.lang.String) value);
//                    }
//                });
//
//        mut_90.register("addComponentViaInterceptor",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getAddComponentViaInterceptor();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_cachePOANames();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("cachePOANames", "cache-poa-names", "java.lang.String", listType, this, false, false, true,
//                        "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 60, acceptedValues));
//        mut_90.register("cachePOANames", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setCachePOANames((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("cachePOANames", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getCachePOANames();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_cacheTypecodes();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("cacheTypecodes", "cache-typecodes", "java.lang.String", listType, this, false, false,
//                        true, "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 50, acceptedValues));
//        mut_90.register("cacheTypecodes", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setCacheTypecodes((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("cacheTypecodes", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getCacheTypecodes();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_chunkCustomRMIValuetypes();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("chunkCustomRMIValueTypes", "chunk-custom-rmi-valuetypes", "java.lang.String", listType,
//                        this, false, false, true, "on", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 290,
//                        acceptedValues));
//        mut_90.register("chunkCustomRMIValueTypes",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setChunkCustomRMIValueTypes((java.lang.String) value);
//                    }
//                });
//
//        mut_90.register("chunkCustomRMIValueTypes",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getChunkCustomRMIValueTypes();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_clientRequires();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "None", "ServerAuth", "ClientAuth", "MutualAuth" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("clientRequires", "client-requires", "java.lang.String", listType, this, false, false,
//                        true, "None", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 370, acceptedValues));
//        mut_90.register("clientRequires", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setClientRequires((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("clientRequires", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getClientRequires();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_clientSupports();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "None", "ServerAuth", "ClientAuth", "MutualAuth" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("clientSupports", "client-supports", "java.lang.String", listType, this, false, false,
//                        true, "MutualAuth", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 360, acceptedValues));
//        mut_90.register("clientSupports", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setClientSupports((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("clientSupports", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getClientSupports();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_comet();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("comet", "comet", "java.lang.String", listType, this, false, false, true, "off", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 270, acceptedValues));
//        mut_90.register("comet", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setComet((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("comet", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getComet();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_exportCorbaloc();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_namingTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("exportCorbaloc", "export-corbaloc", "java.lang.String", listType, this, false, false,
//                        true, "on", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 250, acceptedValues));
//        mut_90.register("exportCorbaloc", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setExportCorbaloc((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("exportCorbaloc", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getExportCorbaloc();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_indirectionEncodingDisable();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("indirectionEncodingDisable", "indirection-encoding-disable", "java.lang.String", listType,
//                        this, false, false, true, "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 310,
//                        acceptedValues));
//        mut_90.register("indirectionEncodingDisable",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setIndirectionEncodingDisable((java.lang.String) value);
//                    }
//                });
//
//        mut_90.register("indirectionEncodingDisable",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getIndirectionEncodingDisable();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_iona();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("iona", "iona", "java.lang.String", listType, this, false, false, true, "off", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 280, acceptedValues));
//        mut_90.register("iona", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setIona((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("iona", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getIona();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_laxBooleanEncoding();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("laxBooleanEncoding", "lax-boolean-encoding", "java.lang.String", listType, this, false,
//                        false, true, "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 300, acceptedValues));
//        mut_90.register("laxBooleanEncoding",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setLaxBooleanEncoding((java.lang.String) value);
//                    }
//                });
//
//        mut_90.register("laxBooleanEncoding",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getLaxBooleanEncoding();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_monitoring();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("monitoring", "monitoring", "java.lang.String", listType, this, false, false, true, "off",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 180, acceptedValues));
//        mut_90.register("monitoring", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setMonitoring((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("monitoring", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getMonitoring();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_printVersion();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("printVersion", "print-version", "java.lang.String", listType, this, false, false, true,
//                        "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 20, acceptedValues));
//        mut_90.register("printVersion", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setPrintVersion((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("printVersion", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getPrintVersion();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_queueWait();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_poaTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("queueWait", "queue-wait", "java.lang.String", listType, this, false, false, true, "off",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 190, acceptedValues));
//        mut_90.register("queueWait", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setQueueWait((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("queueWait", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getQueueWait();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_rootContext();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_namingTab();
//        acceptedValues = new String[] {};
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("rootContext", "root-context", "java.lang.String", listType, this, false, false, true,
//                        "JBoss/Naming/root", label, false, "TEXT_BOX", "TEXT_BOX", subgroup, tabName, 240, acceptedValues));
//        mut_90.register("rootContext", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setRootContext((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("rootContext", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getRootContext();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_security();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_initializersTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("security", "security", "java.lang.String", listType, this, false, false, true, "off",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 160, acceptedValues));
//        mut_90.register("security", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setSecurity((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("security", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getSecurity();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_serverRequires();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "None", "ServerAuth", "ClientAuth", "MutualAuth" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("serverRequires", "server-requires", "java.lang.String", listType, this, false, false,
//                        true, "None", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 390, acceptedValues));
//        mut_90.register("serverRequires", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setServerRequires((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("serverRequires", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getServerRequires();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_serverSupports();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "None", "ServerAuth", "ClientAuth", "MutualAuth" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("serverSupports", "server-supports", "java.lang.String", listType, this, false, false,
//                        true, "MutualAuth", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 380, acceptedValues));
//        mut_90.register("serverSupports", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setServerSupports((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("serverSupports", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getServerSupports();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_strictCheckOnTCCreation();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("strictCheckOnTCCreation", "strict-check-on-tc-creation", "java.lang.String", listType,
//                        this, false, false, true, "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 320,
//                        acceptedValues));
//        mut_90.register("strictCheckOnTCCreation",
//                new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity,
//                            Object value) {
//                        entity.setStrictCheckOnTCCreation((java.lang.String) value);
//                    }
//                });
//
//        mut_90.register("strictCheckOnTCCreation",
//                new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                        return entity.getStrictCheckOnTCCreation();
//                    }
//                });
//
//        label = Console.CONSTANTS.subsys_jacorb_sun();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_interoperabilityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("sun", "sun", "java.lang.String", listType, this, false, false, true, "on", label, false,
//                        "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 260, acceptedValues));
//        mut_90.register("sun", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setSun((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("sun", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getSun();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_supportSSL();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_securityTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("supportSSL", "support-ssl", "java.lang.String", listType, this, false, false, true, "off",
//                        label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 330, acceptedValues));
//        mut_90.register("supportSSL", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setSupportSSL((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("supportSSL", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getSupportSSL();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_transactions();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_initializersTab();
//        acceptedValues = new String[] { "off", "on", "spec" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("transactions", "transactions", "java.lang.String", listType, this, false, false, true,
//                        "off", label, false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 170, acceptedValues));
//        mut_90.register("transactions", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setTransactions((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("transactions", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getTransactions();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_useBOM();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("useBOM", "use-bom", "java.lang.String", listType, this, false, false, true, "off", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 40, acceptedValues));
//        mut_90.register("useBOM", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setUseBOM((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("useBOM", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getUseBOM();
//            }
//        });
//
//        label = Console.CONSTANTS.subsys_jacorb_useIMR();
//        subgroup = "";
//        tabName = Console.CONSTANTS.subsys_jacorb_orbTab();
//        acceptedValues = new String[] { "off", "on" };
//        registry.get(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class).add(
//                new PropertyBinding("useIMR", "use-imr", "java.lang.String", listType, this, false, false, true, "off", label,
//                        false, "COMBO_BOX", "COMBO_BOX", subgroup, tabName, 30, acceptedValues));
//        mut_90.register("useIMR", new Setter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public void invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity, Object value) {
//                entity.setUseIMR((java.lang.String) value);
//            }
//        });
//
//        mut_90.register("useIMR", new Getter<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//            public Object invoke(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem entity) {
//                return entity.getUseIMR();
//            }
//        });
//
//        AddressBinding addr_90 = new AddressBinding();
//        addressing.put(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class, addr_90);
//        addr_90.add("subsystem", "jacorb");
//        factories.put(org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem.class,
//                new EntityFactory<org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem>() {
//                    public org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem create() {
//                        return beanFactory.jacORBSubsystem().as();
//                    }
//                });
//
//        // ---- End org.jboss.as.console.client.shared.subsys.jacorb.model.JacOrbSubsystem ----
//    }

}
