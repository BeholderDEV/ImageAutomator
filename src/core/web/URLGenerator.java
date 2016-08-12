/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.web;

import java.util.List;

/**
 *
 * @author lite
 */
public class URLGenerator {
    private String siteURL;

    public URLGenerator(String siteURL) {
        if(!siteURL.endsWith("/")){
            siteURL = siteURL.concat("/");
        }
        this.siteURL = siteURL;
    }
    
    public String generate(String path){
        if(path.startsWith("http")){
            return path;
        }
        if(path.startsWith("./")){
            path = path.substring(2);
        }
        if(path.startsWith("/")){
            path = path.substring(1);
        }
        return siteURL.concat(path);
    }
}
