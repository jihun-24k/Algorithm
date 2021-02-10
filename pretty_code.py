import sys
input = sys.stdin.readline

N = int(input())
origin_code = list(map(int,input().split()))
correct_code = list(map(int,input().split()))

before = 0
result = 0
for i in range(N):
    current = origin_code[i] - correct_code[i]

    # 양수 일때
    if current >= 0:
        if before < 0:
            result += abs(before)
            before = current
        elif current > before:
            before = current
        else:
            result += before - current
            before = current
    # 음수 일때
    else:
        if before < 0:
            result += before
            before = current
        elif current < before:
            before = current
        else:
            result += abs(before - current)
            before = current
    
result += abs(before)
print(result)