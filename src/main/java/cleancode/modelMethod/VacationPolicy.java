package cleancode.modelMethod;

/**
 * VacationPolicy
 * 除了计算法定最少数量的假期的部分（依据员工类型改变），剩下有大量雷同代码
 *
 * @author Alicia
 * @description
 * @date 2020/6/14
 */
public class VacationPolicy {
    public void accrueUSDDivisionVacation() {
        // code to calculate vacation based on hours worked to date

        // code to ensure vacation meets US minimums

        // code to apply vaction to payroll record
    }

    public void accrueEUDivisionVacation() {
        // code to calculate vacation based on hours worked to date

        // code to ensure vacation meets EU minimums

        // code to apply vacation to payroll record
    }
}
