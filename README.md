<h1>Ticket Booking System (Bus / Railway)</h1>

<h2>Description</h2>
<p>
This project implements a <b>Ticket Booking System</b> using Java, designed to manage passenger reservations, 
seat allocation, cancellations, and waiting lists efficiently.
</p>
<p>
The system uses various <b>data structures and algorithms</b> such as arrays, linked lists, stacks, queues, 
searching, and sorting. It also includes <b>file handling</b> to store and retrieve booking data.
</p>
<hr>
<h2>Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>File Handling (BufferedReader, BufferedWriter, FileWriter, FileReader)</li>
    <li>Data Structures (Arrays, Linked List, Stack, Queue)</li>
    <li>Algorithms (Binary Search, Merge Sort)</li>
</ul>
<hr>
<h2>Features</h2>
<ul>
    <li>Stores ticket and seat details using arrays</li>
    <li>Manages confirmed and waiting passengers using linked lists</li>
    <li>Supports ticket cancellation and undo using stack</li>
    <li>Handles booking requests using queue (FIFO order)</li>
    <li>Performs ticket search using binary search</li>
    <li>Sorts seat numbers using merge sort</li>
    <li>Saves and loads data from files</li>
</ul>
<hr>
<h2>How to Run the Program</h2>
<ol>
    <li>Install Java (JDK)</li>
    <li>Save the file as <code>busticket.java</code></li>
    <li>Compile the program:<br><code>javac busticket.java</code></li>
    <li>Run the program:<br><code>java busticket</code></li>
</ol>
<hr>
<h2>Output</h2>
<p>The program provides a menu-driven interface with options such as:</p>
<ul>
    <li>Booking passengers (confirmed / waiting list)</li>
    <li>Cancelling tickets and managing waiting list</li>
    <li>Viewing confirmed and waiting passengers</li>
    <li>Stack operations (cancel history & undo)</li>
    <li>Queue operations (processing passengers)</li>
    <li>Searching ticket numbers</li>
    <li>Sorting seat numbers</li>
</ul>
<hr>
<p>Generated files:</p>
<ul>
    <li><code>confirmed.txt</code></li>
    <li><code>waiting.txt</code></li>
    <li><code>stack.txt</code></li>
    <li><code>queue.txt</code></li>
    <li><code>tickets.txt</code></li>
    <li><code>seats.txt</code></li>
</ul>
<hr>
<h2>Future Improvements</h2>
<ul>
    <li>We will add <b>3 separate files for proper file handling</b></li>
    <li>Develop a GUI-based interface</li>
    <li>Add database integration (MySQL)</li>
    <li>Implement real-time booking system</li>
    <li>Improve search using advanced techniques</li>
</ul>
