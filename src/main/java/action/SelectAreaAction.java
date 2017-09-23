package action;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.CityDao;
import dao.ProvinceDao;
import dao.RegionDao;
import dao.StreetDao;
import model.City;
import model.Province;
import model.Region;
import model.Street;

public class SelectAreaAction extends ActionSupport{

	
	private Map<String,Object> provincesMap=new HashMap<String,Object>();
	private Map<String,Object> citiesMap=new HashMap<String,Object>();
	private Map<String,Object> regionsMap=new HashMap<String,Object>();
	private Map<String,Object> streetsMap=new HashMap<String,Object>();
	public Map<String, Object> getProvincesMap() {
		return provincesMap;
	}

	public Map<String, Object> getCitiesMap() {
		return citiesMap;
	}

	public Map<String, Object> getRegionsMap() {
		return regionsMap;
	}

	public Map<String, Object> getStreetsMap() {
		return streetsMap;
	}
	public String getProvinces() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		ProvinceDao provinceDao=(ProvinceDao) act.getBean("provinceDao");
		List<Province> provinces=provinceDao.findAll(Province.class);
		//List<Map<Integer,String>> provincesList=new ArrayList<Map<Integer,String>>();
		for(Province province:provinces){
			int proId=province.getProvinceId();
			String proName=province.getProvinceName();
			//System.out.println(proId+" : "+proName);
			//HashMap<Integer,String> pro=new HashMap<Integer,String>();
			provincesMap.put(proId+"", proName);
			//provincesList.add(pro);
		}
		//provincesMap.put("provinces", provincesList);
		return SUCCESS;
	}
	
	public String getCities() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		CityDao cityDao=(CityDao) act.getBean("cityDao");
		HttpServletRequest request=ServletActionContext.getRequest();
		int provinceId=Integer.parseInt(request.getParameter("provinceId"));
		List<City> cities=cityDao.findByProvinceId(provinceId);
		for(City city:cities){
			int cityId=city.getCityId();
			String cityName=city.getCityName();
			//System.out.println(cityName);
			citiesMap.put(cityId+"", cityName);
		}
		//System.out.println(citiesMap.size());
		return SUCCESS;
	}
	
	public String getRegions() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		RegionDao regionDao=(RegionDao) act.getBean("regionDao");
		HttpServletRequest request=ServletActionContext.getRequest();
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		List<Region> regions=regionDao.findByCityId(cityId);
		for(Region region:regions){
			int regionId=region.getRegionId();
			String regionName=region.getRegionName();
			//System.out.println(regionName);
			regionsMap.put(regionId+"", regionName);
		}
		return SUCCESS;
	}
	
	public String getStreets() throws Exception{
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		StreetDao streetDao=(StreetDao) act.getBean("streetDao");
		HttpServletRequest request=ServletActionContext.getRequest();
		int regionId=Integer.parseInt(request.getParameter("regionId"));
		List<Street> streets=streetDao.findByRegionId(regionId);
		for(Street street:streets){
			int streetId=street.getStreetId();
			String streetName=street.getStreetName();
			streetsMap.put(streetId+"", streetName);
		}
		return SUCCESS;
	}
}
