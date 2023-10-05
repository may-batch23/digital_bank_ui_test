package steps;

import io.cucumber.java.DataTableType;
import models.SuccessfulAccountInfo;

import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public SuccessfulAccountInfo newSuccessfulAccountInfoEntry (Map<String, String> entry) {
        String checkingAccountType = entry.get("checkingAccountType");
        String ownership = entry.get("accountOwnership");
        String accountName = (entry.get("accountName"));
        double initialDepositAmount = Double.parseDouble(entry.get("initialDepositAmount"));
        return new SuccessfulAccountInfo(checkingAccountType, ownership, accountName, initialDepositAmount);
    }
}
