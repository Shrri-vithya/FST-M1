player1 = 'player1'
player2 = 'player2'
while True:
    input1 = input("enter player1 choice:").lower()
    input2 = input("enter player2 choice:").lower()

    if input1 == input2:
        print('Its a tie')
    elif input1 == 'rock':
        if input2 == 'paper':
            print('Paper wins')
        else:
            print('Rock wins')

    elif input1 == 'paper':
        if input2 == 'rock':
            print('Paper wins')
        else:
            print('Scissor wins')

    elif input1 == 'scissor':
        if input2 == 'paper':
            print('Scissor wins')
        else:
            print('Rock wins')
    else:
        print('Incorrect input')

    stop_exec = str(input("want another round?")).lower()

    if stop_exec == 'yes':
        continue
    elif stop_exec == 'no':
        raise SystemExit
    else:
        print("incorrect input")
        raise SystemExit
