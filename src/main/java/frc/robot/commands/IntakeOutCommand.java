// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;

// /*
//  * @Authors
//  * Christian
//  * Jackson
//  * FRC 839
//  */

// public class IntakeOutCommand extends Command
// {
//   public IntakeOutCommand()
//   {
//     requires(Robot.intake);
//   }

//   @Override
//   protected void initialize()
//   {

//   }

//   @Override
//   protected void execute()
//   {
//     Robot.intake.outtake();
//   }

//   @Override
//   protected boolean isFinished()
//   {
//     return this.isTimedOut();
//   }

//   @Override
//   protected void end()
//   {
//     Robot.intake.stop();
//   }
// }