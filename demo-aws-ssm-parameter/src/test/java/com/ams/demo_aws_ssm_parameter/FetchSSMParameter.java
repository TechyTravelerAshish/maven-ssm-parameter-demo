package com.ams.demo_aws_ssm_parameter;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class FetchSSMParameter 
{
	static String param_value = null;
	static String param_value1 = null;
	
	/*
	public static String dburl = null;
	
	public static void main(String[] args) 
	{
		dburl = FetchSSMParameter.Fetch_SSM_Parameter("/my-app/dev/db-url");
		
		System.out.println("dburl :- " + dburl);
		
		
		
		
    }

	*/
	
	
	
    public static String Fetch_SSM_Parameter (String param_name) 
    {
        final String USAGE = "\n" +
                "Usage:\n" +
                "    Fetch_SSM_Parameter <paraName>\n\n" +
                "Where:\n" +
                "    paraName - the name of the parameter that you want to fetch from SSM parameter store.\n";
      
        if (param_name.length() != 1) 
        {
            System.out.println(USAGE);
            System.exit(1);
        }
        
        //String paraName = param_name[0]; 
        Region region = Region.US_EAST_1;     

        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .build();

        param_value = getParaValue(ssmClient, param_name);
        ssmClient.close();
        
        return param_value;
    }

    public static String getParaValue (SsmClient ssmClient, String paraName) {

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(paraName)
                .withDecryption(true)
                .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            
            try {
            	param_value1 = parameterResponse.parameter().value();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                        
            //System.out.println("The parameter value fetched from SSM Parameter Store is :- " + parameterResponse.parameter().value());
            System.out.println("The parameter value fetched from SSM Parameter Store is :- " + param_value1);

        } catch (SsmException e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
		return param_value1;
   }
}