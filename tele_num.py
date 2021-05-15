# 백준 5052번 전화번호 목록
from collections import defaultdict

T = int(input())

class TrieNode:
    def __init__(self):
        self.word = False
        self.children = defaultdict(TrieNode)

class Trie:
    def __init__(self):
        self.root = TrieNode()

    # 단어 삽입
    def insert(self, word: str):
        node = self.root
        for char in word:
            node = node.children[char]
        node.word = True

    # 문자열로 시작 단어 존재 여부 판별
    def startsWith(self, prefix: str):
        node = self.root
        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]
        return True

result = []
for _ in range(T):
    t = Trie()
    case = int(input())
    words = []
    cnt = 0
    # 전화번호 입력
    for _ in range(case):
        word = input()
        t.insert(word)
        words.append(word)
    # 판별
    for word in words:
        if t.startsWith(word):
            cnt = 1
    if cnt:
        result.append("No")
    else:
        result.append("Yes")

for res in result:
    print(res)