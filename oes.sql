-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Jun 06, 2021 at 05:07 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oes`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE `course_details` (
  `course_name` varchar(20) NOT NULL,
  `time` time NOT NULL,
  `course_no` int(4) UNSIGNED NOT NULL,
  `date_of_creation` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `hide` smallint(6) UNSIGNED NOT NULL DEFAULT 0,
  `total_question` int(5) UNSIGNED NOT NULL DEFAULT 0,
  `question_mark` int(5) UNSIGNED NOT NULL DEFAULT 4
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`course_name`, `time`, `course_no`, `date_of_creation`, `hide`, `total_question`, `question_mark`) VALUES
('APPTITUDE', '00:30:00', 33, '2020-12-11 10:04:10', 0, 9, 2),
('COMPUTER', '00:00:45', 34, '2018-03-22 17:18:03', 0, 6, 0),
('MATHS', '00:00:30', 32, '2018-01-30 14:25:19', 1, 8, 4);

-- --------------------------------------------------------

--
-- Table structure for table `forgetpass`
--

CREATE TABLE `forgetpass` (
  `uname` varchar(255) NOT NULL DEFAULT 'admin',
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forgetpass`
--

INSERT INTO `forgetpass` (`uname`, `pass`) VALUES
('admin', 'admin1');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `q_id` varchar(5) NOT NULL,
  `q_statement` longtext NOT NULL,
  `option_1` varchar(150) NOT NULL,
  `option_2` varchar(150) NOT NULL,
  `option_3` varchar(150) NOT NULL,
  `option_4` varchar(150) NOT NULL,
  `correct_option` int(1) NOT NULL DEFAULT 1,
  `course_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`q_id`, `q_statement`, `option_1`, `option_2`, `option_3`, `option_4`, `correct_option`, `course_name`) VALUES
('Ap1', 'what 3% of 5% is?', '60%', '30%', '15%', '45%', 2, 'APPTITUDE'),
('AP2', 'In how many ways the letter ‘SOLVING’ can be\nrearranged to make 7 letter words such that none\nof the letters repeat?', '49', '5040', '7670', 'None of the above', 2, 'APPTITUDE'),
('AP3', 'What is the missing letter in this series?\n  b e h k n ? t', 'q', 'r', 's', 'u', 2, 'APPTITUDE'),
('AP4', 'The average age of a group of 5 students was 10.The \naverage age increased by 4 years when 2 new \nstudents joined the group.What is the average age of \nthe two new students who joined the group?', '15', '20', '22', '24', 4, 'APPTITUDE'),
('AP5', 'If you unscramble the letters YKANE, you will get the \nname of a:', 'Mountain Pass', 'Warrior', 'Flower', 'Country', 4, 'APPTITUDE'),
('AP6', '3 is 80% of what number?', '2.50', '3.00', '3.75', '3.50', 3, 'APPTITUDE'),
('AP7', 'In an equation, (96)^(1/2) ÷ (k)^(1/2) = 2*(6)^(1/2);\nwhat value of k will satisfy the equation?', '2', '4', '6', '8', 2, 'APPTITUDE'),
('AP8', 'To the correct number of significant figures, \n(5.0 x 10^-5) ÷ (2.00 x 10^-2) is?', '2.5X10^-7', '2.5X10^-3', '2.50X10^-3', 'None of the above', 2, 'APPTITUDE'),
('AP9', 'The product of 3×2 matrix and 2×3 matrix will result \nin what order matrix?', '3x2', '2x2', '2x3', '3x3', 4, 'APPTITUDE'),
('CM1', 'Who is the father of personal computer?', 'IBM', 'APPLE', 'MS', 'NONE OF THESE', 1, 'COMPUTER'),
('CM2', 'Which is the first electronic digital computer? ', 'ENIAC', 'MARK1 ', 'Z3', 'iCOM', 1, 'COMPUTER'),
('CM3', 'IC chips used in computer are usually made of?		', 'Lead', 'Silicon', 'Gold', 'Silver', 2, 'COMPUTER'),
('CM4', 'INDIA\'s first supercomputer PARAM 8000 was installed in ??', '1990', '1991', '1992', '1993', 1, 'COMPUTER'),
('CM5', 'The CPU\'s ALU contains:', 'RAM Spaces', 'Registers', 'Byte Spaces', 'Secondary Storage spaces', 2, 'COMPUTER'),
('CM6', 'Which is example of recursion : ', 'void func(){return func();}', 'String func(){return \"func()\";}', 'int func(){return 1;}', 'None', 1, 'COMPUTER'),
('MQ1', 'What is the unit digit in the product \nof (3547)^153 * (251)^72  ?', '1', '3', '7', '5', 3, 'MATHS'),
('MQ2', 'What is the remainder when 2^31 is divided by 5 ?', '1', '2', '3', '4', 3, 'MATHS'),
('MQ3', 'The H.C.F of 1.75 , 5.6 , 7 is :  ', '0.07', '0.7', '3.5', '0.35', 4, 'MATHS'),
('MQ4', 'Three numbers are in ratio 1:2:3 and their HCF is 12.\nThe numbers are : ', '4,8,12', '5,10,15', '10,20,30', '12,24,36', 4, 'MATHS'),
('MQ5', 'Two pipes A and B can fill a tank in 36 hours and 45 hours\nrespectively.If both the pipes are opened simultaneously,\nhow much time will be taken to fill the tank ? ', '20 hours', '25 hours', '18 hours', '22 hours', 1, 'MATHS'),
('MQ6', 'A train running at a certain speed crosses a stationary\nengine in 20 seconds.To find out the speed of the train,\nwhich of the following information is necessary ?', 'Only the length of the train', 'Only the length of the engine', 'Either the length of the train or the length of the engine', 'Both the length of the train and the length of the engine', 4, 'MATHS'),
('MQ7', 'If sin x + cosec x = 2,then find the value of\n(sin x)^7 + (cosec x)^7 ?', '1', '2', '0', '2^7', 3, 'MATHS'),
('MQ8', 'On which of the point will the graph of x=3 and y=8 intersect\neach other ', '(0,0)', '(3,8)', '(8,3)', '(-3,-8)', 2, 'MATHS');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `Username` varchar(15) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `time_taken` time NOT NULL DEFAULT '00:00:00',
  `total_questions` int(3) NOT NULL,
  `wrong_question` int(3) NOT NULL,
  `attempted_question` int(3) NOT NULL,
  `obtained_marks` int(5) NOT NULL,
  `total_marks` int(5) NOT NULL,
  `percentage` float NOT NULL,
  `test_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`Username`, `course_name`, `time_taken`, `total_questions`, `wrong_question`, `attempted_question`, `obtained_marks`, `total_marks`, `percentage`, `test_date`) VALUES
('user', 'APPTITUDE', '00:00:29', 9, 2, 5, 6, 18, 33.3333, '2021-01-13 11:00:49');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL DEFAULT '12345',
  `FirstName` varchar(10) NOT NULL,
  `MiddleName` varchar(10) DEFAULT '',
  `LastName` varchar(10) DEFAULT '',
  `Gender` char(1) NOT NULL,
  `E-mail` varchar(30) NOT NULL,
  `Mobile` char(10) NOT NULL,
  `DOB` date NOT NULL,
  `RegNo` int(255) NOT NULL,
  `RegDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `Address` longtext NOT NULL,
  `College` varchar(60) NOT NULL,
  `Verify` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`Username`, `Password`, `FirstName`, `MiddleName`, `LastName`, `Gender`, `E-mail`, `Mobile`, `DOB`, `RegNo`, `RegDate`, `Address`, `College`, `Verify`) VALUES
('user', 'user', 'user', 'user', 'user', 'M', 'user@gmail.com', '9898989898', '2000-06-05', 11, '2021-01-13 10:59:16', 'sangli', 'sangli', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_details`
--
ALTER TABLE `course_details`
  ADD PRIMARY KEY (`course_name`),
  ADD UNIQUE KEY `course_no` (`course_no`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`q_id`),
  ADD KEY `course_name` (`course_name`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD KEY `Username` (`Username`),
  ADD KEY `course_name` (`course_name`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`RegNo`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `E-mail` (`E-mail`),
  ADD UNIQUE KEY `Mobile` (`Mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_details`
--
ALTER TABLE `course_details`
  MODIFY `course_no` int(4) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `RegNo` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userdetails` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
