using namespace std;
#include <iostream>
#include <iomanip>
#include <string>
#include "Clock.h"

void printClocks();
void printMenu();


int main() {
	int h;
	int m;
	int s;
	int x;

	cout << "Set Hours: " << endl;
	std::cin >> h;

	cout << "Set Minutes: " << endl;
	std::cin >> m;

	cout << "Set Seconds: " << endl;
	std::cin >> s;

	setTime(h, m, s); // Call setTime Method

	do { //loop for user input
		cout << "*********************" << " *" << "*********************" << endl;
		cout << "   12 - Hour Clock   " << " *" << "   12 - Hour Clock   " << " *" << endl;
		cout << "* " << get12HourFormat() << " * " << get24HourFormat() << " *" << endl;
		cout << "*********************" << " *" << "*********************" << endl;
	//print menu
		cout << "      Main Menu      " << endl;
		cout << "*********************" << endl;
		cout << " 1 - Add One Hour " << endl;
		cout << " 2 - Add One Minute " << endl;
		cout << " 3 - Add One Second " << endl;
		cout << " 4 - Exit Program " << endl;
		cout << "*********************" << endl;

	//Get user choice
	std::cin >> x;

	//handle user choice
	if (x == 1) {
		addHour(); //update clock
	}
	if (x == 2) {
		addMinute(); //update clock
	}
	if (x == 3) {
		addSecond(); //update clock
	}
	if (x == 4) {
		cout << "Good Bye!"; //print good bye for exit
		break; //exit
	}
	else {
		cout << " Error invalid input!"; //error message for invalid input
	}

	} while (x != 4);
	
	return 0;
}