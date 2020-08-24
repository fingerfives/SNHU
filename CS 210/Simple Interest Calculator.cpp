//
//  main.cpp
//  Project 2
//
//  Author [Joshua Massey]
//  Date [8/4/20]
//  Couse [CS-210]
//

#include <iostream>
#include <iomanip>
#include <stdlib.h>
#include <cmath>
using namespace std;

void DisplayHeader() {
    cout << "==================" << endl;
    cout << "    DATA INPUT    " << endl;
    cout << "==================" << endl;
    cout << "Initial Investment Amount: " << endl;
    cout << "Monthly Deposit: " << endl;
    cout << "Annual Interest: " << endl;
    cout << "Number of Years: " << endl;
}

void AddSpaces() {
    cout << "\n\n\n";
}

void GetUserInput(double& initial, double& recurrDeposit, double& interest, int& years) {
    cin >> initial >> recurrDeposit >> interest >> years;
}

void DisplayUserInput(double& initial, double& recurrDeposit, double& interest, int& years) {
    cout << "==================" << endl;
    cout << "    DATA INPUT    " << endl;
    cout << "==================" << endl;
    cout << "Initial Investment Amount: " << initial << endl;
    cout << "Monthly Deposit: " << recurrDeposit << endl;
    cout << "Annual Interest: " << interest << endl;
    cout << "Number of Years: " << years << endl;
}

void DisplayYearlyCalculation(int& year, double& newBalance, double& earnedInterest) {
    cout << year << "\t\t\t" << newBalance << "\t\t\t\t\t" << earnedInterest << endl;
}

void CalculateBalanceNoDeposits(double& initial, double& interest, int& years) {
    cout << "====================================================" << endl;
    cout << "  Balance and Interest Without Additional Deposits  " << endl;
    cout << "====================================================" << endl;
    cout << "Year\tYear End Balance\tYear End Earned Interest" << endl;
    double oldAmount = initial;
    for(int i = 0; i < years; i++) {
        double interestEarned = 0;
        int year = i + 1;
        //formula for compounding interest = initial * ((1 + interest rate) ^ t)
        //where n = number of times/year
        //and t = number of years
        double newAmount = oldAmount * pow(1 + (interest / 100.0), 1);
        interestEarned = newAmount - oldAmount;
        DisplayYearlyCalculation(year, newAmount, interestEarned);
        oldAmount = newAmount; //do this to set starting amount for next year's caluclatoin
    }
}

void CalculateBalanceWithMonthlyDeposit(double& initial, double& interest,
                                        double& deposit, int& years) {
    cout << "=================================================" << endl;
    cout << "  Balance and Interest With Additional Deposits  " << endl;
    cout << "=================================================" << endl;
    cout << "Year\tYear End Balance\tYear End Earned Interest" << endl;
    double startOfMonthAmount = initial + deposit;
    double endOfMonthAmount = initial;
    double earnedInterest = 0;
    int totalMonths = 12 * years;
    int month = 1;
    int year = 0;
    for(int i = 0; i < totalMonths; i++) {
        startOfMonthAmount = endOfMonthAmount + deposit; //add deposit to recurring deposit
        endOfMonthAmount = startOfMonthAmount * pow(1 + ((interest / 100.0) / 12.0), 1); //calculate end of month balance with interest added
        earnedInterest += endOfMonthAmount - startOfMonthAmount; // calculate earned interest for the month
        if(month % 12 == 0) {
            year += 1;
            DisplayYearlyCalculation(year, endOfMonthAmount, earnedInterest);
        }
        month += 1;
    }
}

int main(int argc, const char * argv[]) {
    cout << fixed << setprecision(2);
    double initialAmount, recurringDeposit, interest;
    int numYears;
    DisplayHeader();
    GetUserInput(initialAmount, recurringDeposit, interest, numYears);
    DisplayUserInput(initialAmount, recurringDeposit, interest, numYears);
    CalculateBalanceNoDeposits(initialAmount, interest, numYears);
    CalculateBalanceWithMonthlyDeposit(initialAmount, interest, recurringDeposit, numYears);
    return 0;
}
