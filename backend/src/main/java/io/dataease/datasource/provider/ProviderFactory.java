package io.dataease.datasource.provider;

import io.dataease.datasource.constants.DatasourceTypes;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;



@Component
public class ProviderFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static DatasourceProvider getProvider(String type){
        DatasourceTypes datasourceType = DatasourceTypes.valueOf(type);
        switch (datasourceType){
            case mysql:
                return context.getBean("jdbc", DatasourceProvider.class);
            case sqlServer:
                return context.getBean("jdbc", DatasourceProvider.class);
            default:
                return context.getBean("jdbc", DatasourceProvider.class);
        }

    }


}
