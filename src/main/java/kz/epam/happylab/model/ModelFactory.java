package kz.epam.happylab.model;

import static kz.epam.happylab.util.Constant.*;

public abstract class ModelFactory {
    private static final String ORDER="order";
    private static final String CUSTOMER="customer";
    private static final String PROBE="probe";
    private static final String AES="aes";
    private static final String PSA="psa";
    private static final String SANPIN="sanpin";
    private static final String REPORT="report";
    private static final String EMPLOYEE="employee";
    private static final String PROFILE = "profile";

    public static Model createModel(String option){
        if(ORDER.equalsIgnoreCase(option)){
            return new OrderModel();
        }
        if(CUSTOMER.equalsIgnoreCase(option)){
            return new CustomerModel();
        }
        if(PROBE.equalsIgnoreCase(option)){
            return new ProbeModel();
        }
        if(AES.equalsIgnoreCase(option)){
            return new AESModel();
        }
        if(PSA.equalsIgnoreCase(option)){
            return new PSAModel();
        }
        if(SANPIN.equalsIgnoreCase(option)){
            return new SanpinModel();
        }
        if(REPORT.equalsIgnoreCase(option)){
            return new ReportModel();
        }
        if(EMPLOYEE.equalsIgnoreCase(option)){
            return new EmployeeModel();
        }
        if(POSITION.equalsIgnoreCase(option)){
            return new PositionModel();
        }
        if(USER.equalsIgnoreCase(option)){
            return new UserModel();
        }
        if(PROFILE.equalsIgnoreCase(option)){
            return new ProfileModel();
        }

        return new ProfileModel();
    }
}
