package edu.frcc.csc.j.Exam2;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class FileTree implements Iterable<FileNode> {
    private FileNode root;

    public FileTree(String path) {
        root = new FileNode(path);
        buildTree(root);
    }

    @Override
    public Iterator<FileNode> iterator() {
        return new DepthFirstIterator();
    }

    // TODO 1: buildTree
    private void buildTree(FileNode fileNode) {
        File file = fileNode.getFile();

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    FileNode childNode = new FileNode(child);
                    fileNode.getChildNodes().add(childNode);
                    buildTree(childNode);
                    fileNode.setFileSize(fileNode.getFileSize() + childNode.getFileSize());
                }
            }
        }
    }

    // TODO 2: DepthFirstIterator (post-order, two-stack approach)
    private class DepthFirstIterator implements Iterator<FileNode> {

        private Deque<FileNode> resultStack = new ArrayDeque<>();

        public DepthFirstIterator() {
            Deque<FileNode> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                FileNode node = stack.pop();
                resultStack.push(node);

                for (FileNode child : node.getChildNodes()) {
                    stack.push(child);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !resultStack.isEmpty();
        }

        @Override
        public FileNode next() {
            return resultStack.pop();
        }
    }

    public Iterator<FileNode> breadthFirstIterator() {
        return new BreadthFirstIterator();
    }
    
    // TODO 3: BreadthFirstIterator (queue-based BFS)
    private class BreadthFirstIterator implements Iterator<FileNode> {

        private Queue<FileNode> queue = new LinkedList<>();

        public BreadthFirstIterator() {
            queue.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public FileNode next() {
            FileNode node = queue.poll();
            for (FileNode child : node.getChildNodes()) {
                queue.offer(child);
            }
            return node;
        }
    }
}