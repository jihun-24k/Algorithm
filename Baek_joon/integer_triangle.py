# 백준 1932번 정수 삼각형 (실버3)
tree = []

def sum(n):
    if n == 0:
        print(tree[0][0])
        return
    else:
        for k in range(len(tree[n-1])):
            tree[n-1][k] += max(tree[n][k], tree[n][k+1])
        return sum(n-1)

n = int(input())
for _ in range(n):
    tree.append(list(map(int, input().split())))
sum(n-1)