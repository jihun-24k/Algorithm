# 백준 1074번 Z
import sys
input = sys.stdin.readline

N, r, c = map(int,input().split())

def z_route(x,y,n,start):
    # 해당 인덱스를 찾았으면 그 값을 반환한다.
    if x == r and y == c:
        print(start)
    else:
        # 1 사면체
        if (r < x+ 2**(n-1) and c < y + 2**(n-1)):
            z_route(x, y, n-1, start)
        # 2 사면체
        if (r < x+ 2**(n-1) and c >= y + 2**(n-1)):
            z_route(x ,y + 2**(n-1) ,n-1, start + 2**(2*(n-1)))
        # 3 사면체
        if (r >= x+ 2**(n-1) and c < y + 2**(n-1)):
            z_route(x+ 2**(n-1) ,y, n-1 , start + 2*2**(2*(n-1)))
        # 4 사면체
        if (r >= x+ 2**(n-1) and c >= y + 2**(n-1)):
            z_route(x+ 2**(n-1) ,y+ 2**(n-1), n-1 ,start + 3*2**(2*(n-1)))

z_route(0,0,N,0)
