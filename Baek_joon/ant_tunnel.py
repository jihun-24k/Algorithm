# 백준 14725번 개미굴

class Node:
    def __init__(self):
        self.word = False
        self.child = {}

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.child:
                node.child[ch] = Node()
            node = node.child[ch]
        node.word = True

    def travel(self, floor, node):
        if node.word:
            return

        leaf = sorted(node.child)

        for l in leaf:
            print("--" * floor + l)
            self.travel(floor + 1, node.child[l])

N = int(input())
t = Trie()
for _ in range(N):
    info = list(input().split())
    t.insert(info[1:])
t.travel(0, t.root)

