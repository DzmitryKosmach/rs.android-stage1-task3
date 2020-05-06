package subtask6

import java.util.*

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        return allPossibleFBT(count).toString()
    }

    private fun allPossibleFBT(count: Int): List<Node> {
        val result: MutableList<Node> = ArrayList()
        if (count % 2 == 0) {
            return result
        }
        if (count == 1) {
            result.add(Node())
            return result
        }
        var i = 1
        while (i < count) {
            val lefts = allPossibleFBT(i)
            val rights = allPossibleFBT(count - i - 1)
            for (l in lefts) {
                for (r in rights) {
                    val root = Node()
                    root.left = l
                    root.right = r
                    result.add(root)
                }
            }
            i += 2
        }
        return result
    }
}

private class Node(var left: Node? = null, var right: Node? = null) {
    override fun toString(): String {
        val result = StringBuilder("[0")
        val queue = LinkedList<Node>()
        var currentNode = this

        do {
            var lastLevel = false
            if (currentNode.left != null || currentNode.right != null) {
                lastLevel = true
            } else {
                for (n in queue) {
                    if (n.left != null || n.right != null) {
                        lastLevel = true
                        break
                    }
                }
            }
            if (lastLevel)
                appendNode(currentNode, result)
            if (currentNode.left != null) queue.add(currentNode.left!!)
            if (currentNode.right != null) queue.add(currentNode.right!!)
            var full = false
            if (queue.isNotEmpty()) {
                currentNode = queue.poll()
                full = true
            }
        } while (queue.isNotEmpty() || full)
        result.append("]")
        return result.toString()
    }

    private fun appendNode(node: Node, builder: StringBuilder) {
        if (node.left != null) {
            builder.append(",0")
        } else {
            builder.append(",null")
        }
        if (node.right != null) {
            builder.append(",0")
        } else {
            builder.append(",null")
        }
    }
}
