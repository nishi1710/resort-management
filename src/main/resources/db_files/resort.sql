CREATE TABLE Resort (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
);

CREATE TABLE Room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    resort_id INT NOT NULL,
    type VARCHAR(50),
    price DECIMAL(10,2),
    facilities TEXT,
    available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (resort_id) REFERENCES Resort(id) ON DELETE CASCADE
);

CREATE TABLE Event (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE AdventureActivity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE ResortEvent (
    resort_id INT,
    event_id INT,
    PRIMARY KEY (resort_id, event_id),
    FOREIGN KEY (resort_id) REFERENCES Resort(id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES Event(id) ON DELETE CASCADE
);

CREATE TABLE ResortActivity (
    resort_id INT,
    activity_id INT,
    PRIMARY KEY (resort_id, activity_id),
    FOREIGN KEY (resort_id) REFERENCES Resort(id) ON DELETE CASCADE,
    FOREIGN KEY (activity_id) REFERENCES AdventureActivity(id) ON DELETE CASCADE
);
