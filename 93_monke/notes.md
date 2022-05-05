# Binary Tree Traversals:

Assuming binary tree:
```
    1  
   / \ 
  2   3
 / \   
4   5

```

### In-order (left, root, right)
`4 2 5 1 3`

1. Traverse the left subtree
2. Process the root
3. Traverse the right subtree

### Pre-order (root, left, right)
`1 2 4 5 3`

1. Process the root
2. Traverse the left subtree, processing as you land on each unprocessed node
3. Traverse the right subtree, processing as you land on each unprocessed node

### Post-order (left, right, root)
`4 5 2 3 1`

1. Traverse the left subtree, processing once all other branches are exhausted
2. Traverse the right subtree, processing once all other branches are exhausted
3. Process the root
