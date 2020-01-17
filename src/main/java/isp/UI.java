package isp;

/**
 * @author wusd
 * @date 2020/1/17 22:20
 */
interface DepositUI {
    void requestDepositAmount();
}
interface WithdrawalUI {
    void requestWithDrawalAmount();
}
abstract class Transaction {
    abstract void execute();
}
class DepositTransaction extends Transaction {
    private DepositUI depositUI;

    public DepositTransaction(DepositUI depositUI) {
        this.depositUI = depositUI;
    }

    @Override
    void execute() {
        depositUI.requestDepositAmount();
    }
}
class WithdrawalTransaction extends Transaction {
    private WithdrawalUI withdrawalUI;

    public WithdrawalTransaction(WithdrawalUI withdrawalUI) {
        this.withdrawalUI = withdrawalUI;
    }

    @Override
    void execute() {
        withdrawalUI.requestWithDrawalAmount();
    }
}
interface TransferUI {
    void requestTransferAmount();
}
class TransferTransaction extends Transaction {
    private TransferUI transferUI;

    public TransferTransaction(TransferUI transferUI) {
        this.transferUI = transferUI;
    }

    @Override
    void execute() {
        transferUI.requestTransferAmount();
    }
}
public abstract class UI implements DepositUI, WithdrawalUI, TransferUI {
    static UI ui;
    public static void main(String[] args) {
        DepositTransaction transaction = new DepositTransaction(ui);
        transaction.execute();
    }
    public static void g(DepositUI depositUI, TransferUI transferUI) {
        
    }

}