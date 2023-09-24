package steps;

import io.cucumber.java.DataTableType;
import models.NewCheckingAccountInfo;

import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public NewCheckingAccountInfo newCheckingAccountInfoEntry (Map<String, String> entry){
        String checkingAccountType = entry.get("checkingAccountType");
        String accountOwnership = entry.get("accountOwnership");
        String accountName = entry.get("accountName");
        double initialDepositAmount = Double.parseDouble(entry.get("initialDepositAmount"));

        return new NewCheckingAccountInfo(checkingAccountType, accountOwnership, accountName, initialDepositAmount);
    }
}
