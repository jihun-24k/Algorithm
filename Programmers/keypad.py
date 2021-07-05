def solution(numbers, hand):
    answer = ''
    left = 10
    right = 12
    for n in numbers:
        if n == 0:
            n = 11
            
        if n == 1 or n == 4 or n == 7:
            left = n
            answer = answer + 'L'  
        elif n == 3 or n == 6 or n == 9:
            right = n
            answer = answer + 'R'
            continue
        else:
            ld = abs(n - left) // 3 + abs(n - left) % 3
            rd = abs(n - right) // 3 + abs(n - right) %3
                
            if ld < rd:
                left = n
                answer = answer + 'L'
            elif rd < ld:
                right = n
                answer = answer + 'R'
            else:
                if hand == "left":
                    left = n
                    answer = answer + 'L'
                else:
                    right = n
                    answer = answer + 'R'
    return answer