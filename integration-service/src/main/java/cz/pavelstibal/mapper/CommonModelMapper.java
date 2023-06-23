package cz.pavelstibal.mapper;

import cz.pavelstibal.domain.Account;
import cz.pavelstibal.domain.CommonModel;
import jakarta.annotation.Nonnull;

public class CommonModelMapper {

    private static final String POST_ACCOUNT = "PostAccount";

    public static CommonModel toCommonModel(@Nonnull final Account account) {
        final CommonModel commonDTO = new CommonModel();
        commonDTO.setOperation(POST_ACCOUNT);
        commonDTO.setApiModel(account);
        return commonDTO;
    }

    private CommonModelMapper() {
    }
}
