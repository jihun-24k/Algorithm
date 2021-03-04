# 백준 2630번 색종이 만들기
import sys
input = sys.stdin.readline

N = int(input())
paper = []
for _ in range(N):
    paper.append(list(map(int, input().split())))

white = 0
blue = 0

# 색종이 나누기
def make_paper (x, y, n):
    # 전역변수로 선언
    global white, blue
    is_paper = 0

    # 각 행의 수들을 더 해준다.
    for i in range(x, x+n):
        for j in range(y,y+n):
            is_paper += paper[i][j]
    
    # 만약 해당 종이가 0 이면
    if is_paper == 0:
        white += 1
    # 만약 해당 종이가 n*n 이면
    elif is_paper == n*n:
        blue += 1
    # 재귀 함수 호출
    else:
        make_paper(x,y,n//2)
        make_paper(x + n//2,y,n//2)
        make_paper(x,y+ n//2,n//2)
        make_paper(x+ n//2,y+ n//2,n//2)

make_paper(0,0,N)
print(white)
print(blue)