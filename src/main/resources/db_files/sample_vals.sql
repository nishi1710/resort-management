INSERT INTO Resort (name, location) VALUES
('Blue Horizon Resort', 'Goa'),
('Mountain View Lodge', 'Manali'),
('Sunset Paradise', 'Kerala');

INSERT INTO Room (resort_id, type, price, facilities, available) VALUES
(1, 'Deluxe Room', 4500.00, 'WiFi, Balcony', TRUE),
(1, 'Family Suite', 7200.00, 'Jacuzzi, WiFi, Kitchenette', TRUE),
(2, 'Standard Room', 3000.00, 'TV, WiFi', FALSE),
(3, 'Premium Cottage', 7000.00, 'Private Pool, Garden View', TRUE);

INSERT INTO Event (name, description) VALUES
('Wedding Packages', 'Customized wedding planning and event coordination.'),
('Live Music Nights', 'Enjoy live bands and DJs every weekend.'),
('Corporate Retreats', 'Facilities for meetings and team building.');

INSERT INTO AdventureActivity (name, description) VALUES
('Trekking', 'Guided mountain trails and nature walks.'),
('Kayaking', 'Exciting water adventure for all skill levels.'),
('Paragliding', 'Soar above the hills with certified instructors.');

INSERT INTO ResortEvent (resort_id, event_id) VALUES
(1, 1), (1, 2),
(2, 3);

INSERT INTO ResortActivity (resort_id, activity_id) VALUES
(1, 2),
(2, 1), (2, 3),
(3, 2);
