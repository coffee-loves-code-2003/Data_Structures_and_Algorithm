def KeypadGeneration(digits,ans):
    if len(digits)==0:
        print(ans)
        return
    key=Keypad[int(digits[0])]
    for i in range(0,len(key)):
        KeypadGeneration(digits[1:],ans+key[i])
digits=input("Enter the string digits")
ans=""
Keypad=[" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
KeypadGeneration(digits,ans)
