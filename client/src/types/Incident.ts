interface Incident {
  id: number;
  description: string;
  reportedAt: string;
  location: string;
  coordinates: { x: number; y: number };
  status: string;
}

export default Incident;
