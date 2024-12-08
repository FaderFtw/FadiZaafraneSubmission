def isTaskDescriptionPalindrome(s):
    #Identify the factors to be excluded from the string
    extras = [' ', '.', ',', "'", ':', ';']
    
    #Replace each  factor by ''
    for extra in extras:
        s = s.replace(extra, "")

    # Palindrome test on the UpperCased string to exclude the capitalization factor 
    return s.upper() == s[::-1].upper()

print(isTaskDescriptionPalindrome('Madam, in Eden, I\'m Adam'))
print(isTaskDescriptionPalindrome('Complete the project report'))
