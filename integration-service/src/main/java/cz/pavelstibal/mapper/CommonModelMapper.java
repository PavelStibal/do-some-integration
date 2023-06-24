package cz.pavelstibal.mapper;

import cz.pavelstibal.domain.Account;
import cz.pavelstibal.domain.CommonModel;
import jakarta.annotation.Nonnull;

public class CommonModelMapper {

    private static final String POST_ACCOUNT = "PostAccount";

    public static CommonModel toCommonModel(@Nonnull final Account account) {
        final CommonModel commonModel = new CommonModel();
        commonModel.setOperation(POST_ACCOUNT);
        commonModel.setApiModel(account);
        return commonModel;
    }

    private CommonModelMapper() {
    }
}
