
package dtu.str.unit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;


public class SystemInfo {

    private static volatile SystemInfo instance = null;

    public static SystemInfo getInstance() {
        SystemInfo ins = SystemInfo.instance;
        if (ins == null) {
            synchronized (SystemInfo.class) {
                ins = SystemInfo.instance;
                if (ins == null) {
                    SystemInfo.instance = ins = new SystemInfo();
                }
            }
        }
        return ins;
    }
    
    private Configuration configuration;

    
    private SystemInfo() {
        if (configuration == null) {
            try {
                PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("conf.properties");
                FileChangedReloadingStrategy reloadingStrategy = new FileChangedReloadingStrategy();
                propertiesConfiguration.setReloadingStrategy(reloadingStrategy);
                configuration = propertiesConfiguration;
            } catch (ConfigurationException e) {
                
            }
        }
    }
   

    public String getString(String key) {
        return configuration.getString(key);
    }

    public int getInt(String key) {
        return configuration.getInt(key);
    }

    public float getFloat(String key){ return configuration.getFloat(key);}

    public boolean getBoolean(String key){
        return configuration.getBoolean(key);
    }

//    public static void main(String[] args) {
//        SystemInfo systemInfo = getInstance();
//        System.out.println(systemInfo.getString("draw.width"));
//    }
}