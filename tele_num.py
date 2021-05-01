# 백준 5052번 전화번호 목록
import sys
input = sys.stdin.readline

T = int(input())

result = []
for _ in range(T):
    N = int(input())
    case = []
    is_ok = True

    for _ in range(N):
        case.append(int(input().strip()))
    case.sort()

    for i in range(len(case)-1):
        if str(case[i]) in str(case[i+1]):
            result.append('NO')
            is_ok = False
            break
    if is_ok:
        result.append('YES')
    
for r in result:
    print(r)