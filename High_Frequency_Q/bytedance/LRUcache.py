class LRUcache:

    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.dummy = Node(0, 0)
        self.dummy.pre = self.dummy
        self.dummy.nxt = self.dummy

    def get(self, key) -> Node | None:

    def put(self, key, value) -> None:

    def getNode(self, key) -> Node | None:

    def 
class Node:

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.pre = None
        self.nxt = None

def main():
    input = sys.stdin.readline
    capacity, q = map(int, input().split())
    cache = LRUcache(capacity)
    res = []

    for _ in range(q):
        operation = input().split()
        if operation[0] == 'put':
            key = int(operation[1])
            value = int(operation[2])
            cache.put(key, value)
        elif operation[0] == 'get':
            key = int(operation[1])
            res.append(str(cache.get(key)))

    print("\n".join(res))

if __name__ == '__main__':
    main()