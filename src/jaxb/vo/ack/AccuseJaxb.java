/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo.ack;

/**
 *
 * @author YOUNES
 */
public class AccuseJaxb {

    protected AccuseHeaderJaxb header;
    protected AccuseInfoJaxb info;

    public AccuseHeaderJaxb getHeader() {
        if(header==null){
            header= new  AccuseHeaderJaxb();
        }
        return header;
    }

    public void setHeader(AccuseHeaderJaxb header) {
        this.header = header;
    }

    public AccuseInfoJaxb getInfo() {
         if(info==null){
            info= new  AccuseInfoJaxb();
        }
        return info;
    }

    public void setInfo(AccuseInfoJaxb info) {
        this.info = info;
    }

}
