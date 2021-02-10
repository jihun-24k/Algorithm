import sys
input = sys.stdin.readline

n = int(input())
# 인덱스 번호를 맞추기 위해 0번지는 0으로 비워놓는다
array = [0] + list(map(int, input().split()))

m = int(input())

questions = []
for _ in range(m):
    questions.append(list(map(int, input().split())))

for start, end in questions:
    