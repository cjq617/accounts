package com.cjq.accounts.entity;

import com.cjq.publics.entity.Page;

/**
 * Created by jq Chen on 2018/5/10.
 */
public class AccountsTotalExample {
    private AccountsExample accountsExample;

    private OtherAccountsExample otherAccountsExample;

    private Page page;

    public AccountsExample getAccountsExample() {
        return accountsExample;
    }

    public void setAccountsExample(AccountsExample accountsExample) {
        this.accountsExample = accountsExample;
    }

    public OtherAccountsExample getOtherAccountsExample() {
        return otherAccountsExample;
    }

    public void setOtherAccountsExample(OtherAccountsExample otherAccountsExample) {
        this.otherAccountsExample = otherAccountsExample;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
