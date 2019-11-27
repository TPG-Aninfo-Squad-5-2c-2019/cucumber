package com.springboot.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.models.dao.CampaignDao;
import com.springboot.app.models.entitys.Campaign;

@Controller
public class CampaignsController {
	
	private void addToModel(Model model,List<Campaign> list) {
		 model.addAttribute("page_title", "Campañas");
	     model.addAttribute("campaigns_list",list);
	}
	
    @RequestMapping(value="/campaigns")
    public String campaigns(Model model) {
    	
    	
    	List<Campaign> list = CampaignDao.getCampaigns();
    	
    	/** add to model **/
    	addToModel(model,list);
        model.addAttribute("campaign_number",1);
        
        return "campaigns";
    }
    
    @GetMapping(value="/campaigns/{campaign_title}")
    public String selectCampaign(@PathVariable(value = "campaign_title") String campaign_name, Model model) {
    	
    	/** add to model **/
    	List<Campaign> list = CampaignDao.getCampaigns();
    	
    	if(campaign_name.equals("Publicitar New Spring ERP 3.0")) {
    		  model.addAttribute("campaign_number",0);
    	}else
    		if(campaign_name.equals("Publicitar CRM 2.1")) {
    			  model.addAttribute("campaign_number",1);
    		}else
    			if(campaign_name.equals("clients")) {
    				return "redirect:/clients";
    			}else
    				if(!campaign_name.equals("Publicitar New Spring ERP 3.0") &&
    				   !campaign_name.equals("Publicitar CRM 2.1") ) {
    					return "redirect:/{campaign_title}";
    				}
    	
    	/** add to model **/
    	addToModel(model,list);
    	
		return "campaigns";
    }
}
