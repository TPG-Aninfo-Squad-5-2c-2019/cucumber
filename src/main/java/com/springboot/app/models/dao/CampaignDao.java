package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;
import com.springboot.app.models.entity.Campaign;
import com.springboot.app.models.entity.Presupuesto;


public class CampaignDao {

	private static CampaignDao campDao =  null;
	
	private static List<Campaign> campaigns = new ArrayList<>();
	
	public static CampaignDao getInstance() {
		
		if(campDao ==  null) {
			
			/*** new Dao***/ 
			campDao =  new CampaignDao();
			
			/*** Campaign 1 ***/
	    	
	    	List<Presupuesto> valoresC1 = new ArrayList<>();
	    	valoresC1.add(new Presupuesto("2019-10-10", 500.0));
	    	valoresC1.add(new Presupuesto("2019-10-15", 1000.0));
	    	valoresC1.add(new Presupuesto("2019-10-20", 1000.0));
	    	valoresC1.add(new Presupuesto("2019-10-25", 5000.0));
	    	valoresC1.add(new Presupuesto("2019-10-30", 3000.0));
	    	valoresC1.add(new Presupuesto("2019-11-5", 2000.0));
	    	valoresC1.add(new Presupuesto("2019-11-10", 2000.0));
	    	
	    	Campaign c1 = new Campaign("Publicitar New Spring ERP 3.0","Google Ads",
	    								"2019-10-10","2019-11-10",valoresC1);
	    	
	    	/*** Campaign 2 ***/
	    
	    	List<Presupuesto> valoresC2 = new ArrayList<>();
	    	valoresC2.add(new Presupuesto("2019-10-10", 500.0));
	    	valoresC2.add(new Presupuesto("2019-10-15", 2000.0));
	    	valoresC2.add(new Presupuesto("2019-10-20", 2000.0));
	    	valoresC2.add(new Presupuesto("2019-10-25", 3000.0));
	    	valoresC2.add(new Presupuesto("2019-10-30", 1000.0));
	    	valoresC2.add(new Presupuesto("2019-11-5", 3000.0));
	    	valoresC2.add(new Presupuesto("2019-11-10", 5000.0));
	    	
	    	Campaign c2 = new Campaign("Publicitar CRM 2.1","Banners en apps móviles",
	    			"9/10/2019","11/12/2019",valoresC2);
	  
	    	/****/
	    	campaigns.add(c1);
	    	campaigns.add(c2);
	    	
		}
		
		return campDao;
	}
	
	public List<Campaign> getCampaigns(){
		return campaigns;
	}
	
	public void addCampaign(Campaign newCampaign) {
		campaigns.add(newCampaign);
	}
	
	public Campaign getCampaign(String nombreCamp) {
		
		for (Campaign campaign : campaigns) {
			if(campaign.getCampaign_title().equals(nombreCamp)) {
				return campaign;
			}
		}
		
		return null;
	}

	public void DeleteCampaign(String titulo) {
		Campaign aBorrar = null;
		
		for (Campaign campaign : campaigns) {
			if(campaign.getCampaign_title().equals(titulo)) {
				aBorrar = campaign;
			}
		}
		campaigns.remove(aBorrar);
	}
	
}
