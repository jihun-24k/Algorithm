# 백준 5052번 전화번호 목록
import sys

input = sys.stdin.readline
T = int(input())

result = []
for _ in range(T):
    case = int(input())
    words = []
    cnt = 0
    # 전화번호 입력
    for _ in range(case):
        word = input().strip()
        words.append(word)
    words.sort()
    # 판별
    for x, y in zip(words, words[1:]):
        if y.startswith(x):
            cnt = 1
            break
    if not cnt:
        result.append("Yes")
    else:
        result.append("No")

for res in result:
    print(res)