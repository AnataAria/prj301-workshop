/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.IDAO;
import dao.MobieDAO;
import java.util.ArrayList;
import java.util.List;
import model.Mobile;

/**
 *
 * @author AnataArisa
 */
public class MobileController {
    IDAO<Mobile> mobileDAO = new MobieDAO();
    
    public List<Mobile> getAllMobileList(){
        return mobileDAO.getAll();
    }
    
    public boolean removeMobileDevice(String uid){
        return mobileDAO.delete(uid);
    }
    
    public boolean updateMobileDevice(Mobile dev){
        return mobileDAO.update(dev);
    }
    
    public List<Mobile> searchByIDOrName(String ID){
        List<Mobile> mobile = new ArrayList();
        if(ID.trim().charAt(0) == 'M'){
            Mobile temp = mobileDAO.read(ID);
            if(temp != null) mobile.add(temp);
        }else{
            List<Mobile> allList = mobileDAO.getAll();
            for(Mobile m: allList){
                if(m.getMobileName().contains(ID)) mobile.add(m);
            }
        }
        return mobile;
    }
    
    public List<Mobile> searchMobileByID(List<String> ID){
        List<Mobile> mobile = new ArrayList();
        for(String a:ID){
            Mobile temp = mobileDAO.read(a);
            if(temp != null) mobile.add(temp);
        }
        return mobile;
    }
    public boolean createMobile(Mobile data){
        if(data != null){
            return mobileDAO.create(data);
        }
        return false;
    }
    
    public List<Mobile> searchMobileByPrice(int min, int max){
        List<Mobile> temp = mobileDAO.getAll();
        List<Mobile> device = new ArrayList<>();
        if(temp != null){
            for(Mobile m: temp){
                if(m.getPrice() >= min && m.getPrice() <= max) device.add(m);
            }
        }
        return device;
    }
}
