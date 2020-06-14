package cleancode.modelMethod;

/**
 * AbstractVacationPolicy
 *
 * @author Alicia
 * @description
 * @date 2020/6/14
 */
public abstract class AbstractVacationPolicy {
    public void accrueVacation() {
        calculateBaseVacationHours();
        alterForLegalMinimums();
        applyToPayroll();
    }

    protected void applyToPayroll(){}

    protected abstract void alterForLegalMinimums(
    );

    private void calculateBaseVacationHours(){

    }


}
