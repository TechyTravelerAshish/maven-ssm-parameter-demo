package com.ams.demo_aws_ssm_parameter;

public class MainClass 
{
	public static String dburl = null;
	
	public static void main(String[] args) 
	{
		dburl = FetchSSMParameter.Fetch_SSM_Parameter("/my-app/dev/db-url");
		
		System.out.println("dburl :- " + dburl);
		
		
		
		
    }


}
