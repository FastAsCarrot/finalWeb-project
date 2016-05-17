/**
 * Created by vrama on 16.05.2016.
 */

function blockAccount() {
    document.choices.action = "/BlockBankAccountServlet";
    document.choices.submit();

    return true;
}

function addMoney() {
    document.choices.action = "/AddMoneyServlet";
    document.choices.submit();

    return true;
}

function withdrawMoney() {
    document.choices.action = "/WithdrawMoneyServlet";
    document.choices.submit();

    return true;
}