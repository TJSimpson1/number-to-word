#include <iostream>
#include <string>

const std::string ones[] = {
    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

const std::string tens[] = {
    "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

std::string getThreeDigitNumberAsWord(int number)
{
    std::string threeDigitWord;
    int hundreds = number / 100;
    if(hundreds > 0){
        threeDigitWord += ones[hundreds] + " hundred ";
    }
    int tensUnit = number % 100;
    if (tensUnit > 0) {
        if (!threeDigitWord.empty()) {
            threeDigitWord += "and ";
        }

        if (tensUnit < 20) {
            threeDigitWord += ones[tensUnit];
        } else {
            int tensDigit = tensUnit / 10;
            int onesDigit = tensUnit % 10;

            threeDigitWord += tens[tensDigit];

            if (onesDigit > 0) {
                threeDigitWord += "-";
                threeDigitWord += ones[onesDigit];
            }
        }
    }
    return threeDigitWord;
}

std::string getWordEquivalent(int number)
{
    const std::string affixes[] = {
    "", " thousand", " million", " billion"};

    if (number < 1 || number > 2000000000)
    {
        return "Number out of range";
    }

    std::string wordEquivalent;
    int i = 0;
    while(number > 0 && i < 4){
        //Process three digits at a time and work upwards
        int threeDigitNumber = number % 1000;
        if(threeDigitNumber > 0){
            std::string threeDigitNumberAsWord = getThreeDigitNumberAsWord(threeDigitNumber);
            wordEquivalent = " " + threeDigitNumberAsWord + affixes[i] + wordEquivalent;
        }
        
        number /= 1000;
        i++;
    }
    return wordEquivalent;
}

int main()
{
    int number;
    std::cout << "Enter a number: ";
    std::cin >> number;

    std::string wordEquivalent = getWordEquivalent(number);
    std::cout << "Word equivalent: " << wordEquivalent << std::endl;

    return 0;
}
