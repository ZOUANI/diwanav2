/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.AbstractJaxbObject;
import util.JaxbUtil;

/**
 *
 * @author YOUNES
 */
public class JaxbConvertor<T extends AbstractJaxbObject> extends JaxbUtil{
    
    public JaxbConvertor(Class entityClass) {
        super(entityClass);
    }
    
}
