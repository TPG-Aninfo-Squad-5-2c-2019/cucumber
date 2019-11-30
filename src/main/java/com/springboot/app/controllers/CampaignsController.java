package com.springboot.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.CampaignDao;
import com.springboot.app.models.dao.IngresoEgresoDao;
import com.springboot.app.models.dao.PresupuestoCreationDTO;
import com.springboot.app.models.entity.Campaign;
import com.springboot.app.models.entity.Presupuesto;

@Controller
public class CampaignsController {
	
	CampaignDao campDao = CampaignDao.getInstance();
	
	private void addToModel(Model model,List<Campaign> list, Campaign encontrada) {
		model.addAttribute("page_title", "Campañas");
	    model.addAttribute("campaigns_list",list);
	    model.addAttribute("campaign_title",encontrada.getCampaign_title());
	    model.addAttribute("presupuestoAprobado",encontrada.getPresupuestosAprobados());
	    model.addAttribute("presupuestoUtilizado",encontrada.getPresupuestosReales());
	    Presupuesto presupuestoVacio = null;
	    for (Presupuesto pres : encontrada.getPresupuestosReales()) {
			if(pres.getMonto() == 0.0) {
				presupuestoVacio = pres;
				break;
			}
		}
	    model.addAttribute("presupuestoIngresado", presupuestoVacio);
     }
	
	public void campaign_creation(Model model) {
		 
		 PresupuestoCreationDTO presupuestoForm = new PresupuestoCreationDTO();
		 
		 for(int i=0; i<10;i++) {
			 presupuestoForm.addPresupuesto(new Presupuesto());
		 }
			 
		 Campaign newCampaign = new Campaign();

		 model.addAttribute("form",presupuestoForm);
		 model.addAttribute("newCampaign", newCampaign);
		
	 }
	
	
   @RequestMapping(value="/campaigns", method = RequestMethod.GET)
    public String campaigns(Model model) {
    
    	addToModel(model,campDao.getCampaigns(),campDao.
    	getCampaign("Publicitar New Spring ERP 3.0"));
    	campaign_creation(model);
        return "campaigns";
    }
    
    @GetMapping(value="/campaigns/{campaign_title}")
    public String selectCampaign(@PathVariable(value = "campaign_title") 
    							String campaign_name, Model model) {
    	
    	Campaign encontrada = campDao.getCampaign(campaign_name);
    	if(encontrada == null) {
    		return "redirect:/{campaign_title}";
    	}
    	
    	 List<Campaign> list = campDao.getCampaigns();
    	addToModel(model,list,encontrada);
    	campaign_creation(model);
    	
		return "campaigns";
    }
    
    @RequestMapping(value="/presupuesto_creation/{title}", method = RequestMethod.POST)
    public String budgetRegister(Model model, @PathVariable(value = "title") 
    							String campaignName,
    							@ModelAttribute Presupuesto presupuestoIngresado){
    	CampaignDao.getInstance().getCampaign(campaignName)
    	.setPresupuestoUtilizado(presupuestoIngresado.getFecha(), 
    							 presupuestoIngresado.getMonto());
    	addToModel(model,campDao.getCampaigns(),campDao.
    			getCampaign(campaignName));
    	campaign_creation(model);
    	
    	return "redirect:/campaigns";
    }
    
    @RequestMapping(value="/campaign_creation", method = RequestMethod.POST)
    public String saved(Model model,@ModelAttribute PresupuestoCreationDTO form,
    					@ModelAttribute Campaign newCampaign) {
	 		
	 		CampaignDao.getInstance().addCampaign(new Campaign(
	 				newCampaign.getCampaign_title(),newCampaign.getMedio_de_difusion(),
			newCampaign.getFecha_inicio(), newCampaign.getFecha_fin(), 
			form.getPresupuestos()));
	 		campaign_creation(model);
	 		addToModel(model,campDao.getCampaigns(),campDao.
	 		    	getCampaign("Publicitar New Spring ERP 3.0"));
        return "redirect:/campaigns";
 }
}
