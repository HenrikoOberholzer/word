# word
This is where I do some cool things with words, firstly anagrams will be shown

#Test cases

Tests we expect would show false value:

    * Both empty ("":"")
    * First value empty then second has value. ("":"value")
    * Second value empty then first value entered.("entered":"")

    * Length of the word would be different. ("value":"NewValue")

    * Enter number for both values. ("2no":"2on")
    * Enter number in first value. ("2not":"ton")
    * Enter number in second value. ("2waha":"ahaw")

    * Enter symbol for both values. ("!ah":"!ah")
    * Enter symbol in first value. ("!ah":"ah")
    * Enter symbol in second value. ("@ah":"ah")

Test we expect would show true value:

    * When the characters match in length and value but different order.("debitcard": "badcredit")
    * When there are more spaces in one than the other.("Debitcard": "Bad credit")
    * Ensure app is case insensitive the following are valid.("indicatory", "Dictionary")

Link you refferred me to specific said letters only.