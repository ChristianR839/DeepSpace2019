// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;

// public class ElevatorMoveCommand extends Command
// {

//   private final double goal;

//   public ElevatorMoveCommand(double goal)
//   {
//     requires(Robot.elevator);
//     this.goal = goal;
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize()
//   {
//     Robot.elevator.setHeight(goal);
//     Robot.elevator.updateSmartDashboard();
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished()
//   {
//     return Robot.elevator.isOnTarget();
//   }
// }